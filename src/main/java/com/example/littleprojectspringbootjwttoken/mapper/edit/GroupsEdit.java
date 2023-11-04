package com.example.littleprojectspringbootjwttoken.mapper.edit;

import com.example.littleprojectspringbootjwttoken.dto.request.CourseRequest;
import com.example.littleprojectspringbootjwttoken.dto.request.GroupsRequest;
import com.example.littleprojectspringbootjwttoken.model.Course;
import com.example.littleprojectspringbootjwttoken.model.Groups;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class GroupsEdit {
    public Groups create(GroupsRequest request) {
        Groups groups = new Groups();
        groups.setGroupName(request.getGroupName());
        return groups;
    }

    public Groups update(GroupsRequest request, Groups groups) {
        groups.setGroupName(request.getGroupName());
        return groups;
    }
}
