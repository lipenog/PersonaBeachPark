package com.example.personabeachpark.booking.areas;

public class Area {
    private String areaID;
    private String name;
    private String description;

    public Area(String areaID, String name, String description) {
        this.areaID = areaID;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAreaID() {
        return areaID;
    }

    public void setAreaID(String areaID) {
        this.areaID = areaID;
    }

    @Override
    public String toString() {
        return "Area -> area: " + areaID + " name: " + name +
                " description: " + description;
    }
}
