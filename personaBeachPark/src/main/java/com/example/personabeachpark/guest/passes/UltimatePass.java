package com.example.personabeachpark.guest.passes;

import com.example.personabeachpark.guest.passes.types.PassType;

public class UltimatePass implements IPass {
    @Override
    public double getPrice() {
        return 300;
    }

    @Override
    public PassType getPassType() {
        return PassType.ULTIMATE;
    }
}
