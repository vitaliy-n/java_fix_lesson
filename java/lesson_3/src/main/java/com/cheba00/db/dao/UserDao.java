package com.cheba00.db.dao;

import com.cheba00.db.models.User;

import java.util.List;

public interface UserDao extends CrudDao<User> {

    List<User> findAllByFirstName(String name);
}
