package com.example.personabeachpark.guest.passes;

import com.example.personabeachpark.guest.passes.types.PassType;

public class MonthlyPass implements IPass {
    @Override
    public double getPrice() {
        return 20;
    }

    @Override
    public PassType getPassType() {
        return PassType.MONTHLY;
    }
}
