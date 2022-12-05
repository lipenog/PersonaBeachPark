package com.example.personabeachpark.food.restaurant;

public class Restaurant {
    private String id;
    private String name;
    private String location;
    private String description;
    private Menu menu;

    public Restaurant(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
