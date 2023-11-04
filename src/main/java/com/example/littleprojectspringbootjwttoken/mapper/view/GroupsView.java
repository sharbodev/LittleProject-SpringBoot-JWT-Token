package com.example.littleprojectspringbootjwttoken.mapper.view;

import com.example.littleprojectspringbootjwttoken.dto.response.CourseResponse;
import com.example.littleprojectspringbootjwttoken.dto.response.GroupsResponse;
import com.example.littleprojectspringbootjwttoken.model.Course;
import com.example.littleprojectspringbootjwttoken.model.Groups;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupsView {
    public GroupsResponse map(Groups groups) {
        GroupsResponse groupsResponse = new GroupsResponse();
        groupsResponse.setGroupName(groups.getGroupName());
        groupsResponse.setId(groups.getId());
        return groupsResponse;
    }

    public List<GroupsResponse> map(List<Groups> groupsList) {
        List<GroupsResponse> list = new ArrayList<>();
        for (Groups groups : groupsList) {
            list.add(map(groups));
        }
        return list;
    }
}
