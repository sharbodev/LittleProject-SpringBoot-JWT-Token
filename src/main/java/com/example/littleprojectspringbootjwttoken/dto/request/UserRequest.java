package com.example.littleprojectspringbootjwttoken.dto.request;

import com.example.littleprojectspringbootjwttoken.model.enums.Role;
import lombok.Data;


@Data
public class UserRequest {
    private String email;
    private String password;
    private String fullName;
    private Role role;
}
