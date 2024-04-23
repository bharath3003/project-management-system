package com.JavaProject.factory;

import com.JavaProject.entity.AdminUser;
import com.JavaProject.entity.ManagerUser;
import com.JavaProject.entity.RegularUser;
import com.JavaProject.entity.User;
public class UserFactory {

    public static User createUser(String role) {
        if ("admin".equalsIgnoreCase(role)) {
            return new AdminUser(role);
        } else if ("manager".equalsIgnoreCase(role)) {
            return new ManagerUser(role);
        } else {
            return new RegularUser(role);
        }
    }
}
