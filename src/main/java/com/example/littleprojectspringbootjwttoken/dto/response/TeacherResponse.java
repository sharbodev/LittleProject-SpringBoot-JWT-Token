package com.example.littleprojectspringbootjwttoken.dto.response;

import com.example.littleprojectspringbootjwttoken.model.enums.Role;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class TeacherResponse {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private Role role;
}
