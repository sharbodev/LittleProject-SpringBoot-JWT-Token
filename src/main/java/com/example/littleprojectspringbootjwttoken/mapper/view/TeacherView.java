package com.example.littleprojectspringbootjwttoken.mapper.view;

import com.example.littleprojectspringbootjwttoken.dto.response.StudentResponse;
import com.example.littleprojectspringbootjwttoken.dto.response.TeacherResponse;
import com.example.littleprojectspringbootjwttoken.model.Student;
import com.example.littleprojectspringbootjwttoken.model.Teacher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherView {
    public TeacherResponse map(Teacher teacher) {
        TeacherResponse teacherResponse = new TeacherResponse();
        teacherResponse.setEmail(teacher.getEmail());
        teacherResponse.setRole(teacher.getRole());
        teacherResponse.setId(teacher.getId());
        return teacherResponse;
    }

    public List<TeacherResponse> map(List<Teacher> teacherList) {
        List<TeacherResponse> list = new ArrayList<>();
        for (Teacher teacher : teacherList) {
            list.add(map(teacher));
        }
        return list;
    }
}
