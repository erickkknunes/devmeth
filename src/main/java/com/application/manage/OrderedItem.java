package com.application.manage;

class OrderedItem {
    private String description;
    private int quantity;
    private double value;
    private double subtotal;

    public OrderedItem(String description, int quantity, double value, double subtotal) {
        this.description = description;
        this.quantity = quantity;
        this.value = value;
        this.subtotal = subtotal;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getValue() {
        return value;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.subtotal = this.quantity * this.value;
    }

    public void setValue(double value) {
        this.value = value;
        this.subtotal = this.quantity * this.value;
    }
}