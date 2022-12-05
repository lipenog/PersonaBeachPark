package com.example.personabeachpark.guest.passes.types;

public enum PassType {
    MONTHLY(0), YEAR(1), ULTIMATE(2);

    private int code;

    private PassType(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }
}