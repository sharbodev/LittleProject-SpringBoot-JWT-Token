package com.example.littleprojectspringbootjwttoken.mapper.view;

import com.example.littleprojectspringbootjwttoken.dto.response.GroupsResponse;
import com.example.littleprojectspringbootjwttoken.dto.response.StudentResponse;
import com.example.littleprojectspringbootjwttoken.model.Groups;
import com.example.littleprojectspringbootjwttoken.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentView {
    public StudentResponse map(Student student) {
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setEmail(student.getEmail());
        studentResponse.setId(student.getId());
        return studentResponse;
    }

    public List<StudentResponse> map(List<Student> studentList) {
        List<StudentResponse> list = new ArrayList<>();
        for (Student student : studentList) {
            list.add(map(student));
        }
        return list;
    }
}
