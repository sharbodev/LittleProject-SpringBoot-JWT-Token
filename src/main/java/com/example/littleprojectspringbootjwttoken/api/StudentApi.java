package com.example.littleprojectspringbootjwttoken.api;

import com.example.littleprojectspringbootjwttoken.dto.request.StudentRequest;
import com.example.littleprojectspringbootjwttoken.dto.request.TeacherRequest;
import com.example.littleprojectspringbootjwttoken.dto.response.StudentResponse;
import com.example.littleprojectspringbootjwttoken.dto.response.TeacherResponse;
import com.example.littleprojectspringbootjwttoken.service.StudentService;
import com.example.littleprojectspringbootjwttoken.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/student")
public class StudentApi {
    private final StudentService studentService;

    @PostMapping("save/student")
    @Operation(summary = "save", description = "save for all student")
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')")
    public StudentResponse save(@RequestBody StudentRequest request, @RequestParam Long id) {
        return studentService.save(request, id);
    }

    @GetMapping("find/by/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER','TEACHER','STUDENT')")
    public StudentResponse findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @GetMapping("find/all")
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER','TEACHER','STUDENT')")
    public List<StudentResponse> findAll() {
        return studentService.findAll();
    }

    @DeleteMapping("delete/by/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')")
    public String deleteById(@PathVariable Long id) {
        return studentService.deleteById(id);
    }

    @DeleteMapping("delete/all")
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')")
    public String deleteAll() {
        return studentService.deleteAll();
    }

    @PutMapping("update/by/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')")
    public StudentResponse updateById(@PathVariable Long id, @RequestBody StudentRequest studentRequest) {
        return studentService.update(id, studentRequest);
    }
}
