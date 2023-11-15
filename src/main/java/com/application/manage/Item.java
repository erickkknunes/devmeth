package com.application.manage;

class Item {
    private int id;
    private String description;
    private int quantity;
    private double value;

    // Constructors

    public Item(int id, String description, int quantity, double value) {
        this.id = id;
        this.description = description;
        this.quantity = quantity;
        this.value = value;
    }

    public Item() {
        // Construtor vazio
    }

    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setValue(double value) {
        this.value = value;
    }
}