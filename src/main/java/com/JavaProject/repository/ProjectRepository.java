package com.JavaProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.JavaProject.entity.Project;
import com.JavaProject.entity.Project.DomainName;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    // Custom query method to retrieve projects by domain
    @Query("SELECT p FROM Project p WHERE p.domain = :domain")
    List<Project> findByDomain(DomainName domain);
}