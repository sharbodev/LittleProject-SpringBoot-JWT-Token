package com.example.littleprojectspringbootjwttoken.mapper.view;

import com.example.littleprojectspringbootjwttoken.dto.response.CompanyResponse;
import com.example.littleprojectspringbootjwttoken.model.Company;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyView {
    public CompanyResponse map(Company company) {
        CompanyResponse companyResponse = new CompanyResponse();
        companyResponse.setCompanyName(company.getCompanyName());
        companyResponse.setEmail(company.getEmail());
        companyResponse.setId(company.getId());
        return companyResponse;
    }

    public List<CompanyResponse> map(List<Company> companyList) {
        List<CompanyResponse> list = new ArrayList<>();
        for (Company company : companyList) {
            list.add(map(company));
        }
        return list;
    }
}
