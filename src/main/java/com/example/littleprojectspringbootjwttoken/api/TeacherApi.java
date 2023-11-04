package com.example.littleprojectspringbootjwttoken.api;

import com.example.littleprojectspringbootjwttoken.dto.request.CourseRequest;
import com.example.littleprojectspringbootjwttoken.dto.request.TeacherRequest;
import com.example.littleprojectspringbootjwttoken.dto.response.CourseResponse;
import com.example.littleprojectspringbootjwttoken.dto.response.TeacherResponse;
import com.example.littleprojectspringbootjwttoken.service.CourseService;
import com.example.littleprojectspringbootjwttoken.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/teacher")
public class TeacherApi {
    private final TeacherService teacherService;

    @PostMapping("save/teacher")
    @Operation(summary = "save", description = "save for all teacher")
    @PreAuthorize("hasAnyAuthority('ADMIN','DIRECTOR','MANAGER','TEACHER')")
    public TeacherResponse save(@RequestBody TeacherRequest request, @RequestParam Long id) {
        return teacherService.save(request, id);
    }

    @GetMapping("find/by/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','DIRECTOR','MANAGER','TEACHER')")
    public TeacherResponse findById(@PathVariable Long id) {
        return teacherService.findById(id);
    }

    @GetMapping("find/all")
    @PreAuthorize("hasAnyAuthority('ADMIN','DIRECTOR','MANAGER','TEACHER')")
    public List<TeacherResponse> findAll() {
        return teacherService.findAll();
    }

    @DeleteMapping("delete/by/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','DIRECTOR','MANAGER','TEACHER')")
    public String deleteById(@PathVariable Long id) {
        return teacherService.deleteById(id);
    }

    @DeleteMapping("delete/all")
    @PreAuthorize("hasAnyAuthority('ADMIN','DIRECTOR','MANAGER','TEACHER')")
    public String deleteAll() {
        return teacherService.deleteAll();
    }

    @PutMapping("update/by/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','DIRECTOR','MANAGER','TEACHER')")
    public TeacherResponse updateById(@PathVariable Long id, @RequestBody TeacherRequest teacherRequest) {
        return teacherService.update(id, teacherRequest);
    }
}
