package com.example.personabeachpark.guest.passes;

import com.example.personabeachpark.guest.passes.types.PassType;

public class YearPass implements IPass {
    @Override
    public double getPrice() {
        return 110;
    }

    @Override
    public PassType getPassType() {
        return PassType.YEAR;
    }
}
