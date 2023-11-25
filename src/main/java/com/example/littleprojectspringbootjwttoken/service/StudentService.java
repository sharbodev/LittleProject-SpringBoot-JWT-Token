package com.example.littleprojectspringbootjwttoken.service;

import com.example.littleprojectspringbootjwttoken.dto.request.CourseRequest;
import com.example.littleprojectspringbootjwttoken.dto.request.StudentRequest;
import com.example.littleprojectspringbootjwttoken.dto.response.CourseResponse;
import com.example.littleprojectspringbootjwttoken.dto.response.StudentResponse;
import com.example.littleprojectspringbootjwttoken.exception.MyError;
import com.example.littleprojectspringbootjwttoken.mapper.edit.CourseEdit;
import com.example.littleprojectspringbootjwttoken.mapper.edit.StudentEdit;
import com.example.littleprojectspringbootjwttoken.mapper.view.CourseView;
import com.example.littleprojectspringbootjwttoken.mapper.view.StudentView;
import com.example.littleprojectspringbootjwttoken.model.Company;
import com.example.littleprojectspringbootjwttoken.model.Course;
import com.example.littleprojectspringbootjwttoken.model.Groups;
import com.example.littleprojectspringbootjwttoken.model.Student;
import com.example.littleprojectspringbootjwttoken.model.enums.Role;
import com.example.littleprojectspringbootjwttoken.repository.CompanyRepository;
import com.example.littleprojectspringbootjwttoken.repository.CourseRepository;
import com.example.littleprojectspringbootjwttoken.repository.GroupsRepository;
import com.example.littleprojectspringbootjwttoken.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    private final StudentView studentView;

    private final StudentEdit studentEdit;

    private final GroupsRepository groupsRepository;

    public StudentResponse save(StudentRequest studentRequest, Long id) {
        Student student = studentEdit.create(studentRequest);
        student.setRole(Role.STUDENT);
        Groups groups = groupsRepository.findById(id).orElseThrow();
        student.setGroups(groups);
        return studentView.map(studentRepository.save(student));
    }

    public List<StudentResponse> findAll() {
        return studentView.map(studentRepository.findAll());
    }

    public StudentResponse findById(Long id) {
        return studentView.map(studentRepository.findById(id).orElseThrow(MyError::new));
    }

    public StudentResponse update(Long id, StudentRequest studentRequest) {
        return studentView.map(studentEdit.update(studentRequest, studentRepository.findById(id).orElseThrow(MyError::new)));
    }

    public String deleteById(Long id) {
        studentRepository.deleteById(id);
        return "deleted!";
    }

    public String deleteAll() {
        studentRepository.deleteAll();
        return "deleted all";
    }
}
