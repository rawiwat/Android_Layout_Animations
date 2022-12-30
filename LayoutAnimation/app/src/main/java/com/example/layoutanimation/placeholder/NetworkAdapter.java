package com.example.layoutanimation.placeholder;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class NetworkAdapter {
    public static final String GET = "GET";
    public static final String POST = "POST";
    public static final String HEAD = "HEAD";
    public static final String OPTION = "OPTION";
    public static final String PUT = "PUT";
    public static final String DELETE = "DELETE";
    public static final String TRACE = "TRACE";

    static String httpRequest(String uriString) {
        return httpRequest(uriString, GET, null, null); }
    static String httpRequest(String uriString, String requestMethod){
        return httpRequest(uriString, requestMethod, null, null);
    }

    static String httpRequest(String uriString, String requestMethod, JSONObject requestBody, Map<String,String> headerProperties){
        String             result = "";
        InputStream        inputStream = null;
        HttpsURLConnection connection = null;

        try {
            URL url = new URL(uriString);
            connection = (HttpsURLConnection) url.openConnection();

            connection.setRequestMethod(requestMethod);

            if (headerProperties != null) {
                for (Map.Entry<String,String> property : headerProperties.entrySet()){
                    connection.setRequestProperty(property.getKey(),property.getValue());
                }
            }
            if (requestMethod.equals(POST) || requestMethod.equals(PUT) && requestBody != null ){
                connection.setDoInput(true);
                final OutputStream outputStream = connection.getOutputStream();
                outputStream.write(requestBody.toString().getBytes());
                outputStream.close();
            } else {
                connection.connect();
            }
            final int responseCode = connection.getResponseCode();
            if (responseCode == HttpsURLConnection.HTTP_OK){
                inputStream = connection.getInputStream();
                if (inputStream != null){
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder builder = new StringBuilder();

                    String line;
                    do{
                        line = reader.readLine();
                        builder.append(line);
                    }while (line != null);
                    result = builder.toString();
                }
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(inputStream!=null){
                try{
                    inputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (connection != null ){
                connection.disconnect();
                }
            }
        return result;
    }
}
