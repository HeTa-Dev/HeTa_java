package com.heta.repo;

import com.heta.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRepository {
    public User findUserById(int id);
    public User findUserByPhoneNum(long phoneNum);
    public void addNewUser(User user);
    public User getUserDetailById(int id);
    public void updateUser(User user);
}
