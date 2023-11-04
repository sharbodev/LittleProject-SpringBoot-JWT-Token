package com.example.littleprojectspringbootjwttoken.service;

import com.example.littleprojectspringbootjwttoken.dto.request.CourseRequest;
import com.example.littleprojectspringbootjwttoken.dto.response.CourseResponse;
import com.example.littleprojectspringbootjwttoken.exception.MyError;
import com.example.littleprojectspringbootjwttoken.mapper.edit.CourseEdit;
import com.example.littleprojectspringbootjwttoken.mapper.view.CourseView;
import com.example.littleprojectspringbootjwttoken.model.Company;
import com.example.littleprojectspringbootjwttoken.model.Course;
import com.example.littleprojectspringbootjwttoken.repository.CompanyRepository;
import com.example.littleprojectspringbootjwttoken.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    private final CourseView courseView;

    private final CourseEdit courseEdit;

    private final CompanyRepository companyRepository;

    public CourseResponse save(CourseRequest courseRequest, Long id) {
        Course course = courseEdit.create(courseRequest);
        Company company = companyRepository.findById(id).orElseThrow();
        course.setCompany(company);
        return courseView.map(courseRepository.save(course));
    }

    public List<CourseResponse> findAll() {
        return courseView.map(courseRepository.findAll());
    }

    public CourseResponse findById(Long id) {
        return courseView.map(courseRepository.findById(id).orElseThrow(MyError::new));
    }

    public CourseResponse update(Long id, CourseRequest catRequest) {
        return courseView.map(courseEdit.update(catRequest, courseRepository.findById(id).orElseThrow(MyError::new)));
    }

    public String deleteById(Long id) {
        courseRepository.deleteById(id);
        return "deleted!";
    }

    public String deleteAll() {
        courseRepository.deleteAll();
        return "deleted all";
    }
}
