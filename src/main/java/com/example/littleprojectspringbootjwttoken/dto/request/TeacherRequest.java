package com.example.littleprojectspringbootjwttoken.dto.request;

import lombok.Data;

@Data
public class TeacherRequest {
    private String email;
    private String password;
}
