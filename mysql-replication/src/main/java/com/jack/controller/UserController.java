package com.jack.controller;

import com.jack.domain.User;
import com.jack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Description
 * <p>
 * </p>
 * DATE 2017/9/23.
 *
 * @author liweijian.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = "application/json")
    public ResponseEntity<Integer> addUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.insertUser(user), HttpStatus.OK);
    }
}