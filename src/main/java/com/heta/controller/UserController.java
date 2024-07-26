package com.heta.controller;

import com.heta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/heta/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/verifyUser/{id}/{passwd}")
    public Map<String,Boolean> verifyUser(@PathVariable("id") int id,@PathVariable("passwd") String passwd){
        boolean result = userService.verifyUser(id,passwd);
        Map<String,Boolean> response = new HashMap<>();
        response.put("result",result);
        return response;
    }
}
