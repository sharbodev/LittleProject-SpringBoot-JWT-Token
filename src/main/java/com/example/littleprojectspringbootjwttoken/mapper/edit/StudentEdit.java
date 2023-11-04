package com.example.littleprojectspringbootjwttoken.mapper.edit;

import com.example.littleprojectspringbootjwttoken.dto.request.GroupsRequest;
import com.example.littleprojectspringbootjwttoken.dto.request.StudentRequest;
import com.example.littleprojectspringbootjwttoken.model.Groups;
import com.example.littleprojectspringbootjwttoken.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentEdit {
    public Student create(StudentRequest request) {
        Student student = new Student();
        student.setEmail(request.getEmail());
        student.setPassword(request.getPassword());
        return student;
    }

    public Student update(StudentRequest request, Student student) {
        student.setPassword(request.getPassword());
        student.setEmail(request.getEmail());
        return student;
    }
}
