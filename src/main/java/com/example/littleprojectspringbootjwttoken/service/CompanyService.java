package com.example.littleprojectspringbootjwttoken.service;

import com.example.littleprojectspringbootjwttoken.dto.request.CompanyRequest;
import com.example.littleprojectspringbootjwttoken.dto.response.CompanyResponse;
import com.example.littleprojectspringbootjwttoken.exception.MyError;
import com.example.littleprojectspringbootjwttoken.mapper.edit.CompanyEdit;
import com.example.littleprojectspringbootjwttoken.mapper.view.CompanyView;
import com.example.littleprojectspringbootjwttoken.model.Company;
import com.example.littleprojectspringbootjwttoken.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyView companyView;
    private final CompanyEdit companyEdit;

    public CompanyResponse save(CompanyRequest companyRequest) {
        Company company = companyEdit.create(companyRequest);
        return companyView.map(companyRepository.save(company));
    }

    public List<CompanyResponse> findAll() {
        return companyView.map(companyRepository.findAll());
    }

    public CompanyResponse findById(Long id) {
        return companyView.map(companyRepository.findById(id).orElseThrow(MyError::new));
    }

    public CompanyResponse update(Long id, CompanyRequest companyRequest) {
        return companyView.map(companyEdit.update(companyRequest, companyRepository.findById(id).orElseThrow(MyError::new)));
    }

    public String deleteById(Long id) {
        companyRepository.deleteById(id);
        return "deleted!";
    }

    public String deleteAll() {
        companyRepository.deleteAll();
        return "deleted all";
    }
}
