package com.example.layoutanimation.placeholder;

public class kmObject {
    private int id;
    private String category,name;

    public kmObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }
}
