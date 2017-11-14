package com.jack.controller;

import com.jack.domain.User;
import com.jack.mapper.test1.User1Mapper;
import com.jack.mapper.test2.User2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

/**
 * Description
 * <p>
 * </p>
 * DATE 2017/11/14.
 *
 * @author liweijian.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private User1Mapper user1Mapper;

    @Autowired
    private User2Mapper user2Mapper;

    @GetMapping("/list")
    public ResponseEntity<?> listUser(User user) {
        return new ResponseEntity<>(user1Mapper.selectUserByCondition(user), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(user1Mapper.selectByPrimaryKey(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        return new ResponseEntity<>(user1Mapper.updateUserByPrimaryKey(user), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<?> insertUser(@RequestBody User user) {
        return new ResponseEntity<>(user1Mapper.insert(user), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return new ResponseEntity<>(user1Mapper.deleteUserByPrimaryKey(id), HttpStatus.OK);
    }

    @GetMapping("/test2ListUser")
    public ResponseEntity<?> test2ListUser(User user) {
        return new ResponseEntity<>(user2Mapper.selectUserByCondition(user), HttpStatus.OK);
    }
}
