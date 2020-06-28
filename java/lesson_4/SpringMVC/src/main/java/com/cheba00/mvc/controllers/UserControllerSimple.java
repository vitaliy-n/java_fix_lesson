package com.cheba00.mvc.controllers;

import com.cheba00.mvc.dao.UserDao;
import com.cheba00.mvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.servlet.mvc.Controller;;import java.util.List;

public class UserControllerSimple implements Controller {
    @Autowired
    private UserDao userDao;

    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) {
        if (httpServletRequest.getMethod().equals("GET")) {
            List<User> users = userDao.findAll();
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("users");
            modelAndView.addObject("usersFromServer", users);
            return modelAndView;
        }
        return null ;
    }
}
