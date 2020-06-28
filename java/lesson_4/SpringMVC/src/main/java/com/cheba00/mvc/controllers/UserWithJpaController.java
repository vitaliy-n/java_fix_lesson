package com.cheba00.mvc.controllers;

import com.cheba00.mvc.forms.UserForm;
import com.cheba00.mvc.models.User;
import com.cheba00.mvc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserWithJpaController {

    @Autowired
    private UserRepository usersRepository;

    @RequestMapping(path = "/jpa/users", method = RequestMethod.GET)
    public ModelAndView getUsers(@RequestParam(required = false, name = "first_name") String firstName) {
        List<User> users = null;

        if (firstName != null) {
            users = usersRepository.findAllByFirstName(firstName);
        } else {
            users = usersRepository.findAll();
        }
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("usersFromServer", users);
        return modelAndView;
    }

    @RequestMapping(path = "/jpa/users", method = RequestMethod.POST)
    public String addUser(UserForm userForm) {
        User newUser = User.from(userForm);
        usersRepository.save(newUser);
        return "redirect:/jpa/users";
    }
}
