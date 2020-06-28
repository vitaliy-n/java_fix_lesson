package com.cheba00.mvc.dao;

import com.cheba00.mvc.models.User;

import java.util.List;
import java.util.Optional;

public interface CrudDao<T> {
    Optional<User> find(Long id);

    void save(T model);

    void update(T model);

    void delete(Integer model);

    List<T> findAll();
}
