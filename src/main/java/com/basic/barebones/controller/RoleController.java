package com.basic.barebones.controller;

import com.basic.barebones.entity.Role;
import com.basic.barebones.entity.User;
import com.basic.barebones.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@AllArgsConstructor
public class RoleController {

    @Autowired
    private final RoleService roleService;

    @PostMapping("/createNewRole")
    public Role createNewRole(@RequestBody Role role){
       return roleService.createNewRole(role);
    }

    @GetMapping("/getAllRoles/{user}")
    public List<Role> getAllRoles(@PathVariable("user") String user){
        return roleService.getAllRoles();
    }


}
