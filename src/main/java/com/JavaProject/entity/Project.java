package com.JavaProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String projectName;
    private String domain;
    private DifficultyLevel difficultyLevel; // Updated to use DifficultyLevel enum

    // Define the domainName enum within the Project class
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

    public enum DifficultyLevel {
        EASY,
        MEDIUM,
        HARD
    }

    private DomainName domainName; // Adding domainName attribute of the enum type

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public DomainName getDomainName() {
        return domainName;
    }

    public void setDomainName(DomainName domainName) {
        this.domainName = domainName;
    }

    @Override
    public String toString() {
        return "Project [id=" + id + ", projectName=" + projectName + ", domain=" + domain + ", difficultyLevel=" + difficultyLevel + ", domainName=" + domainName + "]";
    }
}
