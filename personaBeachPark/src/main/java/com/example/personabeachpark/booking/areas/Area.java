package com.example.personabeachpark.booking.areas;

import com.example.personabeachpark.guest.passes.types.PassType;

public class Area {
    private String areaID;
    private String name;
    private String description;
    private PassType passAccess;

    public Area(String areaID, String name, String description, PassType passAccess) {
        this.areaID = areaID;
        this.name = name;
        this.description = description;
        this.passAccess = passAccess;
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

    public int getPassAccessCode(){
        return passAccess.getCode();
    }

    @Override
    public String toString() {
        return "Area -> area: " + areaID + " name: " + name +
                " description: " + description;
    }
}
