package com.example.littleprojectspringbootjwttoken.mapper.edit;

import com.example.littleprojectspringbootjwttoken.dto.request.CompanyRequest;
import com.example.littleprojectspringbootjwttoken.dto.request.CourseRequest;
import com.example.littleprojectspringbootjwttoken.model.Company;
import com.example.littleprojectspringbootjwttoken.model.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseEdit {
    public Course create(CourseRequest request) {
        Course course = new Course();
        course.setCourseName(request.getCourseName());
        course.setDuration(request.getDuration());
        return course;
    }

    public Course update(CourseRequest request, Course course) {
        course.setDuration(request.getDuration());
        course.setCourseName(request.getCourseName());
        return course;
    }
}
