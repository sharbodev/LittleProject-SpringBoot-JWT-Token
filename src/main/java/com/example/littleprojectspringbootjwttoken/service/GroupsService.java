package com.example.littleprojectspringbootjwttoken.service;

import com.example.littleprojectspringbootjwttoken.dto.request.CourseRequest;
import com.example.littleprojectspringbootjwttoken.dto.request.GroupsRequest;
import com.example.littleprojectspringbootjwttoken.dto.response.CourseResponse;
import com.example.littleprojectspringbootjwttoken.dto.response.GroupsResponse;
import com.example.littleprojectspringbootjwttoken.exception.MyError;
import com.example.littleprojectspringbootjwttoken.mapper.edit.CourseEdit;
import com.example.littleprojectspringbootjwttoken.mapper.edit.GroupsEdit;
import com.example.littleprojectspringbootjwttoken.mapper.view.CourseView;
import com.example.littleprojectspringbootjwttoken.mapper.view.GroupsView;
import com.example.littleprojectspringbootjwttoken.model.Company;
import com.example.littleprojectspringbootjwttoken.model.Course;
import com.example.littleprojectspringbootjwttoken.model.Groups;
import com.example.littleprojectspringbootjwttoken.repository.CompanyRepository;
import com.example.littleprojectspringbootjwttoken.repository.CourseRepository;
import com.example.littleprojectspringbootjwttoken.repository.GroupsRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupsService {
    private final GroupsRepository groupsRepository;

    private final GroupsView groupsView;

    private final GroupsEdit groupsEdit;

    private final CompanyRepository companyRepository;

    private final CourseRepository courseRepository;

    public GroupsResponse save(GroupsRequest groupsRequest, Long id, Long course_id) {
        Groups groups = groupsEdit.create(groupsRequest);
        Course course = courseRepository.findById(course_id).orElseThrow();
        Company company = companyRepository.findById(id).orElseThrow();
        groups.setCompany(company);
        List<Course> courses = new ArrayList<>();
        courses.add(course);
        groups.setCourses(courses);
        return groupsView.map(groupsRepository.save(groups));
    }

    public List<GroupsResponse> findAll() {
        return groupsView.map(groupsRepository.findAll());
    }

    public GroupsResponse findById(Long id) {
        return groupsView.map(groupsRepository.findById(id).orElseThrow(MyError::new));
    }

    public GroupsResponse update(Long id, GroupsRequest groupsRequest) {
        return groupsView.map(groupsEdit.update(groupsRequest, groupsRepository.findById(id).orElseThrow(MyError::new)));
    }

    public String deleteById(Long id) {
        groupsRepository.deleteById(id);
        return "deleted!";
    }

    public String deleteAll() {
        groupsRepository.deleteAll();
        return "deleted all";
    }
}
