package com.ppenchev.notes.controller;

import com.ppenchev.notes.model.User;
import com.ppenchev.notes.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/**")
@AllArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> getUsersById(@RequestParam("user_id") Long id ){
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }
    @PostMapping("/api/users")
    public HttpStatus addNewUser(@RequestBody User user){
        if(user != null){
            return userService.addUser(user);
        }else return HttpStatus.NO_CONTENT;
    }
    @PutMapping("/api/user/{id}")
    public ResponseEntity<User> updateUser(@RequestParam("user_id") Long id, @RequestBody User user){
        if(user != null){
            return new ResponseEntity<>(userService.updateUser(id,user), HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
