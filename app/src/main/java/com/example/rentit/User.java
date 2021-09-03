package com.example.rentit;

public class User {
    String name,lastMessage,phoneNo,country;
    int imageId;

    public User(String name, String lastMessage, String phoneNo, String country, int imageId) {
        this.name = name;
        this.lastMessage = lastMessage;
        this.phoneNo = phoneNo;
        this.country = country;
        this.imageId = imageId;
    }
}
