package com.JavaProject.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.JavaProject.repository.RequestsRepo;
import com.JavaProject.repository.AcceptedRepo;
import com.JavaProject.entity.User;


@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestsRepo requestsRepo;

    @Autowired
    private AcceptedRepo acceptedRepo;

    @Override
    public void acceptRequest(String reqSender, String reqReceiver) {
        // Delete the request from the Requests table
        requestsRepo.deleteByReqSenderAndReqReceiver(reqSender, reqReceiver);
        // Save the accepted request in the Accepted table
        acceptedRepo.saveAcceptedRequest(reqSender, reqReceiver);
    }

    @Override
    public void rejectRequestBySender(String reqSender, String reqReceiver) {
        // Delete the request from the Requests table
        requestsRepo.deleteByReqSenderAndReqReceiver(reqSender, reqReceiver);
    
        
    
    }
}