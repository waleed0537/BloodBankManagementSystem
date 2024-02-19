package com.example.demo5;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BloodTransfusionRequest {
    private final StringProperty bloodType;
    private final StringProperty quantity;

    public BloodTransfusionRequest(String bloodType, String quantity) {
        this.bloodType = new SimpleStringProperty(bloodType);
        this.quantity = new SimpleStringProperty(quantity);
    }

    public StringProperty bloodTypeProperty() {
        return bloodType;
    }

    public StringProperty quantityProperty() {
        return quantity;
    }
}

