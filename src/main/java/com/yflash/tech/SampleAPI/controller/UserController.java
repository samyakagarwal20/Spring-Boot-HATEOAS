package com.yflash.tech.SampleAPI.controller;

import com.yflash.tech.SampleAPI.entity.UserEntity;
import com.yflash.tech.SampleAPI.model.in.GetUserRequest;
import com.yflash.tech.SampleAPI.model.out.User;
import com.yflash.tech.SampleAPI.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
        User user = userService.getUserById(userRequest.getId());
        Link selfLink = linkTo(methodOn(UserController.class).getUserById(userRequest)).withSelfRel();
        user.add(selfLink);
        user.add(linkTo(methodOn(UserController.class).getAllUsers()).withRel("allUsersInfo"));
        return ResponseEntity.status(200).body(user);
    }

}
