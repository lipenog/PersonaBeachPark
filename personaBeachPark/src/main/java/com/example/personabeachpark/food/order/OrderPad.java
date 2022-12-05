package com.example.personabeachpark.food.order;

import java.util.HashSet;
import java.util.Set;

public class OrderPad {
    private Set<ItemsOrder> orders;
    private double total;

    public OrderPad() {
        this.orders = new HashSet<>();
        total = 0;
    }

    public double getTotal(){
        return total;
    }
}
