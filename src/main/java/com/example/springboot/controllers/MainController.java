package com.example.springboot.controllers;


import com.example.springboot.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MainController {

    ArrayList<User> users = new ArrayList<>();

    public MainController() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1, "Lala"));
        users.add(new User(2, "Ola"));
        users.add(new User(5, "Lila"));
        users.add(new User(54, "Max"));
    }

    @GetMapping("/")
    public void mama() {
        System.out.println("hi");
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        ResponseEntity<String> stringResponseEntity = new ResponseEntity<String>("this is body response status", HttpStatus.OK);

        return stringResponseEntity;
    }

    @GetMapping("/users")
    public ArrayList<User> getUsers() {
        return users;

    }

//    @PostMapping("/users")
//    public ResponseEntity<List<User>> saveUser(@RequestBody User user) {
//        users.add(user);
//        return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
//
//   }

    @PostMapping("/users")
    public ResponseEntity<List<User>> saveUser(@RequestParam int id, @RequestParam String name) {
        users.add(new User(id, name));
        return new ResponseEntity<>(users, HttpStatus.ACCEPTED);

    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        User u = users.stream().filter(user -> user.getId() == id).collect(Collectors.toList()).get(0);

        return new ResponseEntity<>(u, HttpStatus.OK);
    }


}

