package com.outdoor.apiservice.controller;

import com.outdoor.apiservice.entity.User;
import com.outdoor.apiservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RestController
@RequestMapping("api")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = userService.getAllUsers();
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }

    @PostMapping("users")
    public ResponseEntity<Void> addUser(@RequestBody User user, UriComponentsBuilder builder) {
        boolean flag = userService.addUser(user);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/users/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }

    @PutMapping("users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
        User usr = userService.getUserById(id);
        if(user.getEmail() != null) {
            usr.setEmail(user.getEmail());
        }
        if(user.getFirstName() != null) {
            usr.setFirstName(user.getFirstName());
        }
        if(user.getFamilyName() != null) {
            usr.setFamilyName(user.getFamilyName());
        }
        if(user.getDescription() != null) {
            usr.setDescription(user.getDescription());
        }
        if(user.getPseudo() != null) {
            usr.setPseudo(user.getPseudo());
        }
        userService.updateUser(usr);
        return new ResponseEntity<User>(usr, HttpStatus.OK);
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
