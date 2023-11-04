package com.example.littleprojectspringbootjwttoken.service.auth;

import com.example.littleprojectspringbootjwttoken.model.User;
import com.example.littleprojectspringbootjwttoken.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElseThrow(() -> {
            throw new RuntimeException("user with" + username + "not found");
        });
        return new AuthUserDetails(user);
    }
}
