package com.application.manage;

import java.util.HashMap;
import java.util.Map;

class OrderForm {
    private String clientName;
    private Map<Integer, Integer> itemQuantities = new HashMap<>();

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Map<Integer, Integer> getItemQuantities() {
        return itemQuantities;
    }

    public void setItemQuantities(Map<Integer, Integer> itemQuantities) {
        this.itemQuantities = itemQuantities;
    }
}