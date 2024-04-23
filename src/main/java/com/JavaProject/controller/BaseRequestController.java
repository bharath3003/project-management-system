package com.JavaProject.controller;


import org.springframework.ui.Model;

import java.security.Principal;

public abstract class BaseRequestController {

    public String handleRequest(Principal principal, Model model) {
        if (principal != null) {
            return handleAuthenticatedRequest(principal, model);
        }
        return handleUnauthenticatedRequest(model);
    }

    protected abstract String handleAuthenticatedRequest(Principal principal, Model model);

    protected abstract String handleUnauthenticatedRequest(Model model);
}
