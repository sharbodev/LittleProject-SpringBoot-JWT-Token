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

    public void save(String email, String password, String fullName, Role role) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setFullName(fullName);
        user.setRole(role);
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
