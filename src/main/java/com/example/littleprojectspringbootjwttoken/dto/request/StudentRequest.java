package com.example.littleprojectspringbootjwttoken.dto.request;

import lombok.Data;

@Data
public class StudentRequest {
    private String email;
    private String password;
}
