package com.basic.barebones.service;

import com.basic.barebones.entity.Role;
import com.basic.barebones.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleService {

    @Autowired
    private final RoleRepository roleRepository;

    public Role createNewRole(Role role) {
       return roleRepository.save(role);
    }

    public List<Role> getAllRoles() {

        return roleRepository.findAll();
    }
}
