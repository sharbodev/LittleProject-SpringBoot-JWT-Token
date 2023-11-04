package com.example.littleprojectspringbootjwttoken.mapper.view;

import com.example.littleprojectspringbootjwttoken.dto.response.CompanyResponse;
import com.example.littleprojectspringbootjwttoken.dto.response.CourseResponse;
import com.example.littleprojectspringbootjwttoken.model.Company;
import com.example.littleprojectspringbootjwttoken.model.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseView {
    public CourseResponse map(Course course) {
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setCourseName(course.getCourseName());
        courseResponse.setDuration(course.getDuration());
        courseResponse.setId(course.getId());
        return courseResponse;
    }

    public List<CourseResponse> map(List<Course> courseList) {
        List<CourseResponse> list = new ArrayList<>();
        for (Course course : courseList) {
            list.add(map(course));
        }
        return list;
    }
}
