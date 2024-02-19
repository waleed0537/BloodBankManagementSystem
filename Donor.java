package com.example.demo5;

public class Donor {
    private String name;
    private String age;
    private String email;
    private String contact;
    private String address;
    private String bloodGroup;

    // Constructor and getter methods

    public Donor(String name, String age, String email, String contact, String address, String bloodGroup) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.bloodGroup = bloodGroup;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }
}
