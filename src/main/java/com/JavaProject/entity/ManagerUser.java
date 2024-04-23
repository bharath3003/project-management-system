package com.JavaProject.entity;

public class ManagerUser extends User {

    public ManagerUser(String role) {
        super(role);
        System.out.println("This is the Manager");
    }
    // Add specific attributes and methods for ManagerUser if needed
}