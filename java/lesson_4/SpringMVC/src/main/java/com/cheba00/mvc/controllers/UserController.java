package com.cheba00.mvc.controllers;

import com.cheba00.mvc.dao.UserDao;
import com.cheba00.mvc.forms.UserForm;
import com.cheba00.mvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    UserDao userDao;

    @RequestMapping(path = "/users", method = RequestMethod.POST)
    public String addUser(UserForm userForm) {
        User newUser = User.from(userForm);
        userDao.save(newUser);

        return "redirect:/users";
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public ModelAndView getAllUsers(@RequestParam(value = "first_name", required = false) String firstName) {
        List<User> users = null;

        if (firstName != null) {
            users = userDao.findAllByFirstName(firstName);
        } else {
            users = userDao.findAll();
        }
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("usersFromServer", users);
        return modelAndView;
    }

    @RequestMapping(path = "/users/{user-id}", method = RequestMethod.GET)
    ModelAndView getUserById(@PathVariable("user-id") Long userId) {
        Optional<User> userCandidate = userDao.find(userId);
        ModelAndView modelAndView = new ModelAndView("users");
        if (userCandidate.isPresent()) {
            modelAndView.addObject("usersFromServer", Collections.singletonList(userCandidate.get()));
        } else {
            List<User> users = new ArrayList<>();
            modelAndView.addObject("userFromServer", users);
        }

        return modelAndView;
    }
}
