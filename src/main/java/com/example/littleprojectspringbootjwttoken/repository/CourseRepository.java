package com.example.littleprojectspringbootjwttoken.repository;

import com.example.littleprojectspringbootjwttoken.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CourseRepository extends JpaRepository<Course,Long> {

}
