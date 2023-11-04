package com.example.littleprojectspringbootjwttoken.api;

import com.example.littleprojectspringbootjwttoken.dto.request.CourseRequest;
import com.example.littleprojectspringbootjwttoken.dto.request.GroupsRequest;
import com.example.littleprojectspringbootjwttoken.dto.response.CourseResponse;
import com.example.littleprojectspringbootjwttoken.dto.response.GroupsResponse;
import com.example.littleprojectspringbootjwttoken.service.CourseService;
import com.example.littleprojectspringbootjwttoken.service.GroupsService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/groups")
public class GroupsApi {
    private final GroupsService groupsService;

    @PostMapping("save/groups")
    @Operation(summary = "save", description = "save for all groups")
    @PreAuthorize("hasAnyAuthority('ADMIN','DIRECTOR','MANAGER')")
    public GroupsResponse save(@RequestBody GroupsRequest request, @RequestParam Long id, @RequestParam Long course_id) {
        return groupsService.save(request, id, course_id);
    }

    @GetMapping("find/by/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','DIRECTOR','MANAGER')")
    public GroupsResponse findById(@PathVariable Long id) {
        return groupsService.findById(id);
    }

    @GetMapping("find/all")
    @PreAuthorize("hasAnyAuthority('ADMIN','DIRECTOR','MANAGER')")
    public List<GroupsResponse> findAll() {
        return groupsService.findAll();
    }

    @DeleteMapping("delete/by/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','DIRECTOR','MANAGER')")
    public String deleteById(@PathVariable Long id) {
        return groupsService.deleteById(id);
    }

    @DeleteMapping("delete/all")
    @PreAuthorize("hasAnyAuthority('ADMIN','DIRECTOR','MANAGER')")
    public String deleteAll() {
        return groupsService.deleteAll();
    }

    @PutMapping("update/by/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','DIRECTOR','MANAGER')")
    public GroupsResponse updateById(@PathVariable Long id, @RequestBody GroupsRequest groupsRequest) {
        return groupsService.update(id, groupsRequest);
    }
}
