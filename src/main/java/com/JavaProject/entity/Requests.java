package com.JavaProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Requests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String req_receiver;
    private String req_sender;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReq_receiver() {
        return req_receiver;
    }

    public void setReq_receiver(String req_receiver) {
        this.req_receiver = req_receiver;
    }

    public String getReq_sender() {
        return req_sender;
    }

    public void setReq_sender(String req_sender) {
        this.req_sender = req_sender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Requests [id=" + id + ", req_receiver=" + req_receiver + ", req_sender=" + req_sender + ", status=" + status + "]";
    }
}