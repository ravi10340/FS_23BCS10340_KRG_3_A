package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;


@RestController
@RequestMapping("api/users/")
public class UserController {
    @Autowired
    private UserService UserService;

    @GetMapping()
    public List<Student> getUsers(){
        return UserService.findAllUsers();
    } 
}
