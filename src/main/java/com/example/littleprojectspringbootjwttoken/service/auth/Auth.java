package com.example.littleprojectspringbootjwttoken.service.auth;

import com.example.littleprojectspringbootjwttoken.config.JwtUtils;
import com.example.littleprojectspringbootjwttoken.model.User;
import com.example.littleprojectspringbootjwttoken.model.enums.Role;
import com.example.littleprojectspringbootjwttoken.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Auth {
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;

    public void save(String fullName, String email, String password, Role role) {
        User user = new User();
        user.setEmail(email);
        user.setRole(role);
        user.setFullName(fullName);
        user.setPassword(passwordEncoder.encode(password));
        if (userRepository.existsByEmail(email)){
            throw new RuntimeException("user exists email");
        }
        userRepository.save(user);
    }

    public String login(String email, String password) {
        User user = userRepository.findByEmail(email).get();
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("invalid password");
        }
        return jwtUtils.generateToken(email);
    }
}
