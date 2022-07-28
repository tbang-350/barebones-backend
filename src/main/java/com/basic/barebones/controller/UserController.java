package com.basic.barebones.controller;

import com.basic.barebones.dto.UserDto;
import com.basic.barebones.dto.UserUpdateDto;
import com.basic.barebones.entity.ContractorChartdata;
import com.basic.barebones.entity.EmployeeChartdata;
import com.basic.barebones.entity.User;
import com.basic.barebones.repository.RoleRepository;
import com.basic.barebones.repository.UserRepository;
import com.basic.barebones.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    private final UserRepository userRepository;



    private final ModelMapper modelMapper;



    @PostMapping("/registerContractor")
    public User registerContractor(@RequestBody UserDto userDto){
        return userService.registerContractor(userDto);
    }

    @PostMapping("/registerEmployee")
    public User registerEmployee(@RequestBody UserDto userDto){
        return userService.registerEmployee(userDto);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/getContractors")
    public List<User> getContractors(){
        return userRepository.findAllContractors();
    }

    @GetMapping("/getEmployees")
    public List<User> getEmployee(){
        return userRepository.findAllEmployees();
    }

    @DeleteMapping("/deleteUser/{user_id}")
    public void deleteUser(@PathVariable("user_id") Long user_id){
        userService.deleteUser(user_id);
    }

    @PutMapping("/updateContractor")
    public ResponseEntity<User> updateContractor(@RequestBody UserUpdateDto userUpdateDto){
        return userService.updateContractor(userUpdateDto);
    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<User> updateEmployee(@RequestBody UserUpdateDto userUpdateDto){
        return userService.updateEmployee(userUpdateDto);
    }

    @GetMapping("/countContractors")
    public int countContractors(){
       return  userRepository.countAllContractors();
    }

    @GetMapping("/countEmployees")
    public int countEmployees(){
        return userRepository.countAllEmployees();
    }
    @GetMapping("/countAllUsers")
    public int countAllUsers(){
        return userRepository.countAllUsers();
    }

    @GetMapping("/getChartdata")
    public EmployeeChartdata getChartdata(){
        return userRepository.getChartdata();
    }

    @GetMapping("/getContractorChartdata")
    public ContractorChartdata getContractorChartdata(){
        return userRepository.getContractorChartdata();
    }

    @GetMapping("/login/user/{user}/pass/{pass}")
    public User login(@PathVariable("user") String userName, @PathVariable("pass") String userPassword){
        return userService.login(userName,userPassword);
    }

}
