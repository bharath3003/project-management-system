package com.JavaProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import com.JavaProject.factory.UserFactory;
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String mobileNo;
    private String email;
    private String password;
    private String role;

    // Define the domainName enum within the User class
    public enum DomainName {
        MACHINE_LEARNING,
        CYBERSECURITY,
        CLOUD_COMPUTING,
        BLOCKCHAIN,
        IOT,
        ROBOTICS,
        ARTIFICIAL_INTELLIGENCE,
        DATA_SCIENCE,
        COMPUTER_GRAPHICS
    }
    public User(){
        
    }
    public User(String role) {
        this.role = role;
    }

    public static User createUser(String role) {
        return UserFactory.createUser(role);
    }
    

    private DomainName domainName; // Adding domainName attribute of the enum type

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public DomainName getDomainName() {
        return domainName;
    }

    public void setDomainName(DomainName domainName) {
        this.domainName = domainName;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", mobileNo=" + mobileNo + ", password=" + password + ", domainName=" + domainName + "]";
    }
    
}




