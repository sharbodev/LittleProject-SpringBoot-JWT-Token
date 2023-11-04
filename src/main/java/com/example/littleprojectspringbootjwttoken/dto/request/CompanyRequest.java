package com.example.littleprojectspringbootjwttoken.dto.request;

import lombok.Data;

@Data
public class CompanyRequest {
    private String email;
    private String companyName;
    private String password;
    
}
