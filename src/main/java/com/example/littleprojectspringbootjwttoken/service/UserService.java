package com.example.littleprojectspringbootjwttoken.service;

import com.example.littleprojectspringbootjwttoken.dto.request.CompanyRequest;
import com.example.littleprojectspringbootjwttoken.dto.request.UserRequest;
import com.example.littleprojectspringbootjwttoken.dto.response.CompanyResponse;
import com.example.littleprojectspringbootjwttoken.dto.response.UserResponse;
import com.example.littleprojectspringbootjwttoken.exception.MyError;
import com.example.littleprojectspringbootjwttoken.mapper.edit.CompanyEdit;
import com.example.littleprojectspringbootjwttoken.mapper.edit.UserEdit;
import com.example.littleprojectspringbootjwttoken.mapper.view.CompanyView;
import com.example.littleprojectspringbootjwttoken.mapper.view.UserView;
import com.example.littleprojectspringbootjwttoken.model.Company;
import com.example.littleprojectspringbootjwttoken.model.User;
import com.example.littleprojectspringbootjwttoken.repository.CompanyRepository;
import com.example.littleprojectspringbootjwttoken.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserView userView;
    private final UserEdit userEdit;

    public UserResponse save(UserRequest userRequest) {
        User user = userEdit.create(userRequest);
        return userView.map(userRepository.save(user));
    }

    public List<UserResponse> findAll() {
        return userView.map(userRepository.findAll());
    }

    public UserResponse findById(Long id) {
        return userView.map(userRepository.findById(id).orElseThrow(MyError::new));
    }

    public UserResponse update(Long id, UserRequest userRequest) {
        return userView.map(userEdit.update(userRequest, userRepository.findById(id).orElseThrow(MyError::new)));
    }

    public String deleteById(Long id) {
        userRepository.deleteById(id);
        return "deleted!";
    }

    public String deleteAll() {
        userRepository.deleteAll();
        return "deleted all";
    }
}
