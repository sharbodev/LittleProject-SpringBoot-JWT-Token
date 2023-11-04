package com.example.littleprojectspringbootjwttoken.mapper.edit;

import com.example.littleprojectspringbootjwttoken.dto.request.CompanyRequest;
import com.example.littleprojectspringbootjwttoken.model.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyEdit {

    public Company create(CompanyRequest request) {
        Company company = new Company();
        company.setCompanyName(request.getCompanyName());
        company.setEmail(request.getEmail());
        company.setPassword(request.getPassword());

        return company;
    }

    public Company update(CompanyRequest request, Company company) {
        company.setPassword(request.getPassword());
        company.setCompanyName(request.getCompanyName());
        company.setEmail(request.getEmail());
        company.setPassword(request.getPassword());

        return company;
    }
}
