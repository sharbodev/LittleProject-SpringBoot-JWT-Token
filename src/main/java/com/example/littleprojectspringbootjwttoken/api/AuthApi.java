package com.example.littleprojectspringbootjwttoken.api;

import com.example.littleprojectspringbootjwttoken.model.enums.Role;
import com.example.littleprojectspringbootjwttoken.service.auth.Auth;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class AuthApi {
    private final Auth auth;

    @PostMapping("save")
    public String save(@RequestParam String email, @RequestParam String password, @RequestParam String fullName, @RequestParam Role role) {
        auth.save(email, password, fullName, role);
        return "ok";
    }

    @PostMapping("login")
    public String save(@RequestParam String email, @RequestParam String password) {
        return auth.login(email, password);
    }
}
