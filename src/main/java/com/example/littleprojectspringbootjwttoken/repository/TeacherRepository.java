package com.example.littleprojectspringbootjwttoken.repository;

import com.example.littleprojectspringbootjwttoken.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
@Repository
@Transactional
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByEmail(String email);

    boolean existsByEmail(String email);
}
