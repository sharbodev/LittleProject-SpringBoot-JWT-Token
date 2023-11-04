package com.example.littleprojectspringbootjwttoken.model;

import com.example.littleprojectspringbootjwttoken.model.enums.Role;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Teacher {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
