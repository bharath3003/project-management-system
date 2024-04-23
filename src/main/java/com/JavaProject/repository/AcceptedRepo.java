package com.JavaProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import com.JavaProject.entity.Accepted;
import java.util.List;

public interface AcceptedRepo extends JpaRepository<Accepted, Integer> {
    
    @Modifying
    @Transactional
    @Query("INSERT INTO Accepted (user, friend) VALUES (:reqReceiver, :reqSender)")
    void saveAcceptedRequest(String reqSender, String reqReceiver);
    
    @Transactional(readOnly = true)
    static
    List<Accepted> findByUser(String user) {
        
        throw new UnsupportedOperationException("Unimplemented method 'findByUser'");
    }
}