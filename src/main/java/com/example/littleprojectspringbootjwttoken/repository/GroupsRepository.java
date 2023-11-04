package com.example.littleprojectspringbootjwttoken.repository;

import com.example.littleprojectspringbootjwttoken.model.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Transactional
@Repository
public interface GroupsRepository extends JpaRepository<Groups,Long> {

}
