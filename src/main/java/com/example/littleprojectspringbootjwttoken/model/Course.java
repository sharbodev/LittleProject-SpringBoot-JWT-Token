package com.example.littleprojectspringbootjwttoken.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private String duration;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
    private Teacher teacher;

    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    private List<Groups> groupsList;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
