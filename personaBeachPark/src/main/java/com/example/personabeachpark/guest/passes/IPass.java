package com.example.personabeachpark.guest.passes;

import com.example.personabeachpark.guest.passes.types.PassType;

public interface IPass {
    public abstract double getPrice();
    public abstract PassType getPassType();
}
