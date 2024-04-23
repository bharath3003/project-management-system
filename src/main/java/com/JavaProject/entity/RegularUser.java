package com.JavaProject.entity;

public class RegularUser extends User {

    public RegularUser(String role) {
        super(role);
        System.out.println("This is a regular user");
    }
    
}
