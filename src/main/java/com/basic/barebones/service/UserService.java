package com.basic.barebones.service;

import com.basic.barebones.config.Sha3Util;
import com.basic.barebones.dto.UserDto;
import com.basic.barebones.dto.UserUpdateDto;
import com.basic.barebones.entity.Role;
import com.basic.barebones.entity.User;
import com.basic.barebones.repository.RoleRepository;
import com.basic.barebones.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.*;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final RoleRepository roleRepository;

    private final ModelMapper modelMapper;

    public User registerContractor(UserDto userDto) {

        User user = modelMapper.map(userDto, User.class);

        Optional<User> contractorOptional = userRepository.findUserByUsername(user.getUserName());

        if (contractorOptional.isPresent()) {
            throw new IllegalStateException("Contractor already exists");
        }

        Role role = roleRepository.findByRoleName("Contractor").get();

        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles((Set<Role>) roles);
        byte[] shaInBytes = Sha3Util.digest(user.getUserPassword().getBytes(StandardCharsets.UTF_8));
        user.setUserPassword(Sha3Util.bytesToHex(shaInBytes));
        user.setRegisteredAt(LocalDateTime.now());

        return userRepository.save(user);
    }

    public User registerEmployee(UserDto userDto) {

        User user = modelMapper.map(userDto, User.class);

        Optional<User> employeeOptional = userRepository.findUserByUsername(user.getUserName());

        if (employeeOptional.isPresent()) {
            throw new IllegalStateException("Employee already exists");
        }

        Role emp_role = roleRepository.findByRoleName("Employee").get();

        Set<Role> emp_roles = new HashSet<>();
        emp_roles.add(emp_role);
        user.setRoles((Set<Role>) emp_roles);
        byte[] shaInBytes = Sha3Util.digest(user.getUserPassword().getBytes(StandardCharsets.UTF_8));
        user.setUserPassword(Sha3Util.bytesToHex(shaInBytes));
        user.setRegisteredAt(LocalDateTime.now());
        System.out.println(user.getUserPassword());

        return userRepository.save(user);
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long user_id) {
        boolean exists = userRepository.existsById(user_id);

        if (!exists){
            throw new IllegalStateException("user does not exist");
        }

        userRepository.deleteById(user_id);
    }

   public ResponseEntity<User> updateContractor(UserUpdateDto userUpdateDto){
       User user = modelMapper.map(userUpdateDto, User.class);

       Role emp_role = roleRepository.findByRoleName("Contractor").get();

       Set<Role> emp_roles = new HashSet<>();
       emp_roles.add(emp_role);
       user.setRoles((Set<Role>) emp_roles);
       User updatedUser = userRepository.save(user);

       return ResponseEntity.ok(updatedUser );
   }

    public ResponseEntity<User> updateEmployee(UserUpdateDto userUpdateDto){
        User user = modelMapper.map(userUpdateDto, User.class);

        Role emp_role = roleRepository.findByRoleName("Employee").get();

        Set<Role> emp_roles = new HashSet<>();
        emp_roles.add(emp_role);
        user.setRoles((Set<Role>) emp_roles);
        User updatedUser = userRepository.save(user);


        return ResponseEntity.ok(updatedUser );
    }



    public User login(String userName, String userPassword) {
        byte[] sha3Bytes = Sha3Util.digest(userPassword.getBytes(StandardCharsets.UTF_8));
        String encrypted = Sha3Util.bytesToHex(sha3Bytes);
        return userRepository.getLogin(userName, encrypted);
    }
}
