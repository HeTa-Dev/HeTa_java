package com.heta.repo;

import com.heta.entity.User;

public interface UserRepository {
    public User findUserById(int id);
}
