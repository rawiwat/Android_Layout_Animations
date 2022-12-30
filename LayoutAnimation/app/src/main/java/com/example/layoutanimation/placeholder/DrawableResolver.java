package com.example.layoutanimation.placeholder;

import com.example.layoutanimation.R;

public class DrawableResolver {
    public static final String  CHARACTER = "character";
    public static final String PLANET = "planet";
    public static final String TRAIN = "train";
    public static final String VEHICLE = "vehicle";

    public static int getDrawableId(String category,int id){
        int drawable;
        try{
            switch (category){
                case CHARACTER:
                    drawable = characters[id];
                    break;
                case PLANET:
                    drawable = planets[id];
                    break;
                case TRAIN:
                    drawable = train[id];
                    break;
                case VEHICLE:
                    drawable = vehicles[id];
                    break;
                default:
                    drawable = R.drawable.kuuga;
            }
        }catch (ArrayIndexOutOfBoundsException e){
            drawable = R.drawable.kuuga;
        }
        return drawable;
    }
    public static final int[]characters = new int[]{
            R.drawable.kuuga,
            R.drawable.agito,
            R.drawable.ryuki,
            R.drawable.faiz,
            R.drawable.blade,
            R.drawable.hibiki,
            R.drawable.kabuto,
            R.drawable.den_o,
            R.drawable.kiva,
            R.drawable.decade
    };
    public static final int[] planets = new int[]{
            R.drawable.mirrorworld
    };
    public static final int[] train = new int[]{
            R.drawable.denliner
    };
    public static final int[] vehicles = new int[]{
            R.drawable.vehicleskuuga,
            R.drawable.vehiclesagito,
            R.drawable.vehiclesryuki,
            R.drawable.vehiclesfaiz,
            R.drawable.vehiclesblade,
            R.drawable.vehicleshibiki,
            R.drawable.vehicleskabuto,
            R.drawable.vehiclesden_o,
            R.drawable.vehicleskiva,
            R.drawable.vehiclesdecade
    };
}
