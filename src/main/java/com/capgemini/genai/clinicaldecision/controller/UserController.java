package com.capgemini.genai.clinicaldecision.controller;

import com.capgemini.genai.clinicaldecision.model.User;
import com.capgemini.genai.clinicaldecision.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        userService.registerUser(user);
        model.addAttribute("users", userService.getAllUsers());
        return "fragments/user-list :: userList";
    }

    @PostMapping("/search")
    public String searchUsers(@RequestParam String username, Model model) {
        List<User> users = userService.searchUsers(username);
        model.addAttribute("users", users);
        return "fragments/user-list :: userList";
    }
}