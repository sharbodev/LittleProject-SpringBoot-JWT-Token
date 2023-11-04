package com.example.littleprojectspringbootjwttoken.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "groups")
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String groupName;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "groups", cascade = CascadeType.ALL)
    private List<Student> students;


    @ManyToMany
    @JoinTable(name = "course_groups",
            joinColumns = @JoinColumn(name = "groups_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    @Override
    public String toString() {
        return "Groups{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
