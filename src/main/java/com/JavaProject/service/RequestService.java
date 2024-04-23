package com.JavaProject.service;

import com.JavaProject.entity.Requests;


public interface RequestService {
    void acceptRequest(String reqSender, String reqReceiver);
    void rejectRequestBySender(String reqSender, String reqReceiver);
    
}