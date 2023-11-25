package com.example.littleprojectspringbootjwttoken.service;

import com.example.littleprojectspringbootjwttoken.dto.request.CourseRequest;
import com.example.littleprojectspringbootjwttoken.dto.request.TeacherRequest;
import com.example.littleprojectspringbootjwttoken.dto.response.CourseResponse;
import com.example.littleprojectspringbootjwttoken.dto.response.TeacherResponse;
import com.example.littleprojectspringbootjwttoken.exception.MyError;
import com.example.littleprojectspringbootjwttoken.mapper.edit.TeacherEdit;
import com.example.littleprojectspringbootjwttoken.mapper.view.TeacherView;
import com.example.littleprojectspringbootjwttoken.model.Company;
import com.example.littleprojectspringbootjwttoken.model.Course;
import com.example.littleprojectspringbootjwttoken.model.Teacher;
import com.example.littleprojectspringbootjwttoken.model.enums.Role;
import com.example.littleprojectspringbootjwttoken.repository.CourseRepository;
import com.example.littleprojectspringbootjwttoken.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherView teacherView;
    private final TeacherEdit teacherEdit;
    private final CourseRepository courseRepository;

    public TeacherResponse save(TeacherRequest teacherRequest, Long id) {
        Teacher teacher = teacherEdit.create(teacherRequest);
        teacher.setRole(Role.TEACHER);
        Course course = courseRepository.findById(id).orElseThrow();
        teacher.setCourse(course);
        return teacherView.map(teacherRepository.save(teacher));
    }

    public List<TeacherResponse> findAll() {
        return teacherView.map(teacherRepository.findAll());
    }

    public TeacherResponse findById(Long id) {
        return teacherView.map(teacherRepository.findById(id).orElseThrow(MyError::new));
    }

    public TeacherResponse update(Long id, TeacherRequest teacherRequest) {
        return teacherView.map(teacherEdit.update(teacherRequest, teacherRepository.findById(id).orElseThrow(MyError::new)));
    }

    public String deleteById(Long id) {
        teacherRepository.deleteById(id);
        return "deleted!";
    }

    public String deleteAll() {
        teacherRepository.deleteAll();
        return "deleted all";
    }
}
