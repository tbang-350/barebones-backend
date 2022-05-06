package com.basic.barebones.service;

import com.basic.barebones.entity.Role;
import com.basic.barebones.entity.User;
import com.basic.barebones.repository.RoleRepository;
import com.basic.barebones.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final RoleRepository roleRepository;

    public User registerUser(User user){

        Optional<User> contractorOptional = userRepository.findUserByUsername(user.getUserName());

        if (contractorOptional.isPresent()){
            throw new IllegalStateException("Contractor already exists");
        }

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


    public void updateUser(Long user_id, String userName, String userPassword, String firstName, String lastName) {
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new IllegalStateException("user does not exist"));

        if (userName != null && userName.length() > 0 && !Objects.equals(user.getUserName(), userName)){
            Optional<User> userOptional = userRepository.findUserByUsername(userName);

            if (userOptional.isPresent()){
                throw new IllegalStateException("user exixsts");
            }
            user.setUserName(userName);
        }

        if (userPassword != null && userPassword.length() > 0 && !Objects.equals(user.getUserPassword(), userPassword)){
            user.setUserPassword(userPassword);
        }

        if (firstName != null && firstName.length() > 0 && !Objects.equals(user.getFirstName(), firstName)){
            user.setFirstName(firstName);
        }

        if (lastName != null && lastName.length() > 0 && !Objects.equals(user.getLastName(), lastName)){
            user.setLastName(lastName);
        }
    }
}
