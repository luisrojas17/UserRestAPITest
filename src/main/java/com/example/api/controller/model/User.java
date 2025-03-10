package com.example.api.controller.model;

import lombok.Data;

@Data
public class User {
    private String id;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;
}
