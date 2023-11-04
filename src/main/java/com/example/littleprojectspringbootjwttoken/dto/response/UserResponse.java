package com.example.littleprojectspringbootjwttoken.dto.response;

import com.example.littleprojectspringbootjwttoken.model.enums.Role;
import lombok.Data;

import javax.persistence.*;

@Data
public class UserResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private Role role;
    private String fullName;
}
