package com.cheba00.repositories;

import com.cheba00.models.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    void save(User user);

    boolean isExist(String name, String password);
    
}
