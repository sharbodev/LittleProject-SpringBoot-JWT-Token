package com.example.littleprojectspringbootjwttoken.mapper.view;

import com.example.littleprojectspringbootjwttoken.dto.response.TeacherResponse;
import com.example.littleprojectspringbootjwttoken.dto.response.UserResponse;
import com.example.littleprojectspringbootjwttoken.model.Teacher;
import com.example.littleprojectspringbootjwttoken.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserView {
    public UserResponse map(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setEmail(user.getEmail());
        userResponse.setRole(user.getRole());
        userResponse.setId(user.getId());
        userResponse.setFullName(user.getFullName());
        return userResponse;
    }

    public List<UserResponse> map(List<User> userList) {
        List<UserResponse> list = new ArrayList<>();
        for (User user : userList) {
            list.add(map(user));
        }
        return list;
    }
}
