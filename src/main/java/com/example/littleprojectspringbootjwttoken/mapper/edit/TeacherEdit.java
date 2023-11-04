package com.example.littleprojectspringbootjwttoken.mapper.edit;

import com.example.littleprojectspringbootjwttoken.dto.request.StudentRequest;
import com.example.littleprojectspringbootjwttoken.dto.request.TeacherRequest;
import com.example.littleprojectspringbootjwttoken.model.Student;
import com.example.littleprojectspringbootjwttoken.model.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherEdit {
    public Teacher create(TeacherRequest request) {
        Teacher teacher = new Teacher();
        teacher.setEmail(request.getEmail());
        teacher.setPassword(request.getPassword());
        return teacher;
    }

    public Teacher update(TeacherRequest request, Teacher teacher) {
        teacher.setPassword(request.getPassword());
        teacher.setEmail(request.getEmail());
        return teacher;
    }
}
