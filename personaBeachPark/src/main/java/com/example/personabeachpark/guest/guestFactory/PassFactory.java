package com.example.personabeachpark.guest.guestFactory;

import com.example.personabeachpark.guest.passes.IPass;
import com.example.personabeachpark.guest.passes.MonthlyPass;
import com.example.personabeachpark.guest.passes.UltimatePass;
import com.example.personabeachpark.guest.passes.YearPass;
import com.example.personabeachpark.guest.passes.types.PassType;

public class PassFactory {
    private static PassFactory singleton;
    private IPass pass;

    private PassFactory(){

    }

    public static PassFactory getInstance(){
        if(singleton == null){
            singleton = new PassFactory();
        }
        return singleton;
    }

    public IPass createPass(PassType passType){
        if(passType == PassType.MONTHLY){
            pass = new MonthlyPass();
        } else if (passType == PassType.YEAR) {
            pass = new YearPass();
        } else if (passType == PassType.ULTIMATE) {
            pass = new UltimatePass();
        }
        return pass;
    }

}
