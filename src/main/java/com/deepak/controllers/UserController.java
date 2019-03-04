package com.deepak.controllers;

import com.deepak.User;
import com.deepak.UserService;
import com.deepak.exceptions.UserNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
    @RequestMapping("/welcome/{name}")
    public Map<String, String> welcome(@PathVariable("name") String name) {
        //return "Welcome, " + name;
        Map<String, String> response = new HashMap<>();
        response.put("success", "response");
        return response;
    }
    
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public @ResponseBody
    ResponseEntity<User> getUser(@PathVariable("id") int id) {
        User user = userService.getUserById(id);
        if (user == null) {
            throw new UserNotFound("User with id " + id + " not found");
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public @ResponseBody
    ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
        User userById = userService.getUserById(id);
        if (userById == null) {
            throw new UserNotFound("User with id " + id + " not found");
        }
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") int id) {
        User userById = userService.getUserById(id);
        if (userById == null) {
            throw new UserNotFound("User with id " + id + " not found");
        }
        
        user.setId(id);
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }
}

