package com.heta.repo;

import com.heta.entity.User;

import java.util.List;

public interface UserRepository {
    User findUserById(int id);
    User findUserByPhoneNum(long phoneNum);
    void addNewUser(User user);
    User getUserDetailById(int id);
    void updateUser(User user);
    List<User> getContactById(int id);
    void setBanned(int id);
    void setUnbanned(int id);
}
