package com.heta.repo;

import com.heta.entity.User;

public interface UserRepository {
    public User findUserById(int id);
    public User findUserByPhoneNum(long phoneNum);
    public void addNewUser(User user);
}
