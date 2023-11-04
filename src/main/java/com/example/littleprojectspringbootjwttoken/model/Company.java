package com.example.littleprojectspringbootjwttoken.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String companyName;
    private String password;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Course> courses;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Groups> groups;

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

