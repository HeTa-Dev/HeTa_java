package com.heta.service;

import com.heta.entity.User;
import com.heta.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean verifyUser(int id,String passwd){
        User user = userRepository.findUserById(id);
        if(user == null){
            return false;
        }
        return user.getPasswd().equals(passwd);
    }
    public User findUserById(int id){
        return userRepository.findUserById(id);
    }
}
