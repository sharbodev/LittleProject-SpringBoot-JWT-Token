package com.example.littleprojectspringbootjwttoken.api;

import com.example.littleprojectspringbootjwttoken.dto.request.CompanyRequest;
import com.example.littleprojectspringbootjwttoken.dto.response.CompanyResponse;
import com.example.littleprojectspringbootjwttoken.service.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/company")
@RequiredArgsConstructor
public class CompanyApi {
    private final CompanyService companyService;

    @PostMapping("save/company")
    @Operation(summary = "save", description = "save for all company")
    @PreAuthorize("hasAnyAuthority('ADMIN','DIRECTOR')")
    public CompanyResponse save(@RequestBody CompanyRequest request) {
        return companyService.save(request);
    }

    @GetMapping("find/by/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','DIRECTOR')")
    public CompanyResponse findById(@PathVariable Long id) {
        return companyService.findById(id);
    }

    @GetMapping("find/all")
    @PreAuthorize("hasAnyAuthority('ADMIN','DIRECTOR')")
    public List<CompanyResponse> findAll() {
        return companyService.findAll();
    }

    @DeleteMapping("delete/by/id")
    @PreAuthorize("hasAnyAuthority('ADMIN','DIRECTOR')")
    public String deleteById(@PathVariable Long id) {
        return companyService.deleteById(id);
    }

    @DeleteMapping("delete/all")
    @PreAuthorize("hasAnyAuthority('ADMIN','DIRECTOR')")
    public String deleteAll() {
        return companyService.deleteAll();
    }

    @PutMapping("update/by/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','DIRECTOR')")
    public CompanyResponse updateById(@PathVariable Long id, @RequestBody CompanyRequest companyRequest) {
        return companyService.update(id, companyRequest);
    }
}
