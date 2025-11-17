package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;


@Repository
public interface UserRepo extends JpaRepository<Student,Long>{
    Optional<Student>  findByUsername(String user);
    Optional<Student>  findByUsernameLike(String user);
}
