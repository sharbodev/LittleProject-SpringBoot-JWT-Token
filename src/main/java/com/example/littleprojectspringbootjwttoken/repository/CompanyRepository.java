package com.example.littleprojectspringbootjwttoken.repository;

import com.example.littleprojectspringbootjwttoken.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface CompanyRepository extends JpaRepository<Company, Long>{

}
