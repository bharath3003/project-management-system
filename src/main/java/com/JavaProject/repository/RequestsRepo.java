package com.JavaProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import com.JavaProject.entity.Requests;

public interface RequestsRepo extends JpaRepository<Requests, Integer> {
    
    @Modifying
    @Transactional
    @Query("DELETE FROM Requests r WHERE r.req_sender = :reqSender or r.req_receiver = :reqReceiver")
    void deleteByReqSenderAndReqReceiver(String reqSender, String reqReceiver);

    @Modifying
    @Transactional
    @Query("INSERT INTO Accepted (user, friend) VALUES (:reqReceiver, :reqSender)")
    void saveAcceptedRequest(String reqSender, String reqReceiver);
}