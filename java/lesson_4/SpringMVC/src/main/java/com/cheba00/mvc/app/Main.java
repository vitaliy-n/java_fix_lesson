package com.cheba00.mvc.app;

import com.cheba00.mvc.dao.UserDao;
import com.cheba00.mvc.dao.UsersDaoJdbcTemplateImpl;
import com.cheba00.mvc.models.User;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qwertyu1234567");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/fix_users_db");

        UserDao userDao = new UsersDaoJdbcTemplateImpl(dataSource);

        List<User> users = userDao.findAll();
        System.out.println(users);

    }
}
