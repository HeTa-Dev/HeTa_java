package com.heta.service;

import com.heta.entity.User;
import com.heta.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//连接UserRepository接口和UserController的类，可能需要进行一些逻辑判断等操作
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean verifyUser(long phoneNumber,String passwd){
        User user = userRepository.findUserByPhoneNum(phoneNumber);
        if(user == null){
            return false;
        }
        return user.getPasswd().equals(passwd);
    }
    public User findUserById(int id){
        return userRepository.findUserById(id);
    }
    public User findUserByPhoneNum(long phoneNum){
        return userRepository.findUserByPhoneNum(phoneNum);
    }
    public void addNewUser(User user){
        userRepository.addNewUser(user);
    }

    public User getUserDetailById(int id){
        return userRepository.getUserDetailById(id);
    }
}
