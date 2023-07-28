package com.dailyCodeBuffer.Springdemo.Controller;

import com.dailyCodeBuffer.Springdemo.Model.User;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class HomeController {

    @GetMapping("/")
    public String hello(){
        return "Hello world!";
    }


    @PostMapping("/user")
    public User addUser(){
        User user = new User();

        user.setId(UUID.randomUUID().toString());
        user.setFirstName("Bhargava");
        user.setLastName("BR");
        user.setAddress("Bengaluru");
        return user;
    }

    @GetMapping("/{id}")
    public String pathVariableDemo(@PathVariable int id){
        return "Path variable Id is: "+id;
    }

    @GetMapping("/request")
    public String requestParam(@RequestParam(name="firstName") String name,
                                @RequestParam(required = false, defaultValue = "") String age){
        return "Name is "+name +" age is "+age;
    }

}
