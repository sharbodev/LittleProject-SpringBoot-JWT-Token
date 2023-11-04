package com.example.littleprojectspringbootjwttoken.mapper.edit;

import com.example.littleprojectspringbootjwttoken.dto.request.UserRequest;
import com.example.littleprojectspringbootjwttoken.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserEdit {
    public User create(UserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        user.setFullName(request.getFullName());
        return user;
    }

    public User update(UserRequest request, User user) {
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setFullName(request.getFullName());
        user.setRole(request.getRole());
        return user;
    }
}
