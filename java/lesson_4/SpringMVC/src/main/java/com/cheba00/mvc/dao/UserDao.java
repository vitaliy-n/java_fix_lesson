package com.cheba00.mvc.dao;

import com.cheba00.mvc.models.User;

import java.util.List;

public interface UserDao extends CrudDao<User> {

    List<User> findAllByFirstName(String name);
}
