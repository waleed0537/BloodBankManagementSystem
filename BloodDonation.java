package com.example.demo5;


public class BloodDonation {
    private String donorName;
    private String bloodType;

    // Constructors
    public BloodDonation() {
    }

    public BloodDonation(String donorName, String bloodType) {
        this.donorName = donorName;
        this.bloodType = bloodType;
    }

    // Getters and Setters
    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }



}

