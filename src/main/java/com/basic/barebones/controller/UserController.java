package com.basic.barebones.controller;

import com.basic.barebones.entity.User;
import com.basic.barebones.repository.UserRepository;
import com.basic.barebones.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    private final UserRepository userRepository;

    @PostMapping("/registerUser")
    public User registerContractor(User user){
        return userService.registerUser(user);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping(path = "{user_id}")
    public void deleteUser(@PathVariable("user_id") Long user_id){
        userService.deleteUser(user_id);
    }

    @PutMapping(path = "{user_id}")
    public void updateUser(
            @PathVariable("user_id") Long user_id,
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) String userPassword,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName
    ){
        userService.updateUser(user_id,userName,userPassword,firstName,lastName);
    }
}
