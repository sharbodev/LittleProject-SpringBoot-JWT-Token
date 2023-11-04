package com.example.littleprojectspringbootjwttoken.api;

import com.example.littleprojectspringbootjwttoken.dto.request.CourseRequest;
import com.example.littleprojectspringbootjwttoken.dto.response.CourseResponse;
import com.example.littleprojectspringbootjwttoken.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/course")
public class CourseApi {
    private final CourseService courseService;

    @PostMapping("save/course")
    @Operation(summary = "save", description = "save for all course")
    @PreAuthorize("hasAnyAuthority('ADMIN','DIRECTOR')")
    public CourseResponse save(@RequestBody CourseRequest request, @RequestParam Long id) {
        return courseService.save(request, id);
    }

    @GetMapping("find/by/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','DIRECTOR')")
    public CourseResponse findById(@PathVariable Long id) {
        return courseService.findById(id);
    }

    @GetMapping("find/all")
    @PreAuthorize("hasAnyAuthority('ADMIN','DIRECTOR')")
    public List<CourseResponse> findAll() {
        return courseService.findAll();
    }

    @DeleteMapping("delete/by/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','DIRECTOR')")
    public String deleteById(@PathVariable Long id) {
        return courseService.deleteById(id);
    }

    @DeleteMapping("delete/all")
    @PreAuthorize("hasAnyAuthority('ADMIN','DIRECTOR')")
    public String deleteAll() {
        return courseService.deleteAll();
    }

    @PutMapping("update/by/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','DIRECTOR')")
    public CourseResponse updateById(@PathVariable Long id, @RequestBody CourseRequest courseRequest) {
        return courseService.update(id, courseRequest);
    }
}
