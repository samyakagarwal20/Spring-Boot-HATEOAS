package com.yflash.tech.SampleAPI.controller;

import com.yflash.tech.SampleAPI.entity.UserEntity;
import com.yflash.tech.SampleAPI.model.in.GetUserRequest;
import com.yflash.tech.SampleAPI.model.out.User;
import com.yflash.tech.SampleAPI.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping(value = "/get-all-users", produces = "application/json")
    ResponseEntity<List<UserEntity>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "/get-user-by-id", produces = "application/json", consumes = "application/json")
    ResponseEntity<User> getUserById(@RequestBody GetUserRequest userRequest) {
        return new ResponseEntity<>(userService.getUserById(userRequest.getId()), HttpStatus.OK);
    }

}
