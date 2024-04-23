package com.JavaProject.entity;

public class AdminUser extends User{

    public AdminUser(String role) {
        super(role);
        System.err.println("This is the admin ");
    } 
    
}
