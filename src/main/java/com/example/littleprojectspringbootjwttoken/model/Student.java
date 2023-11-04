package com.example.littleprojectspringbootjwttoken.model;

import com.example.littleprojectspringbootjwttoken.model.enums.Role;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "groups_id")
    private Groups groups;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
