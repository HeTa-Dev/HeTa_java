package com.heta.controller;

import com.heta.entity.User;
import com.heta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/heta/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/verifyUser/{phoneNum}/{passwd}")
    public Map<String,Boolean> verifyUser(@PathVariable("phoneNum") long phoneNum,@PathVariable("passwd") String passwd){
        boolean result = userService.verifyUser(phoneNum,passwd);
        Map<String,Boolean> response = new HashMap<>();
        response.put("result",result);
        return response;
    }

    @GetMapping("/findUserById/{id}")
    public User findUserById(@PathVariable("id") int id){
        return userService.findUserById(id);
    }

    @GetMapping("/findUserByPhoneNum/{phoneNum}")
    public User findUserByPhoneNum(@PathVariable("phoneNum") long phoneNum){
        return userService.findUserByPhoneNum(phoneNum);
    }

    @PostMapping("/addNewUser")
    public Map<String,Boolean> addNewUser(@RequestBody User user){
        Map<String,Boolean> resultMap = new HashMap<>();
        if(userService.findUserByPhoneNum(user.getPhoneNum())!=null){
            resultMap.put("duplicated",true);
        }else {
            resultMap.put("duplicated",false);
            userService.addNewUser(user);
        }
        return resultMap;
    }
}
