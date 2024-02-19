package com.example.demo5;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BloodDrive {
    private final StringProperty location;
    private final StringProperty date;
    private final StringProperty time;

    public BloodDrive(String location, String date, String time) {
        this.location = new SimpleStringProperty(location);
        this.date = new SimpleStringProperty(date);
        this.time = new SimpleStringProperty(time);
    }

    public String getLocation() {
        return location.get();
    }

    public StringProperty locationProperty() {
        return location;
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getTime() {
        return time.get();
    }

    public StringProperty timeProperty() {
        return time;
    }

    public void setTime(String time) {
        this.time.set(time);
    }
}
