package com.example.personabeachpark.food.order;

import com.example.personabeachpark.food.restaurant.MenuItem;

public class ItemsOrder {
    private MenuItem item;
    private int quantity;

    public ItemsOrder(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public double getSubTotal(){
        return item.getPrice() * quantity;
    }
}
