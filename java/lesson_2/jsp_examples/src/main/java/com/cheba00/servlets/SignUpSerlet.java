package com.cheba00.servlets;

import com.cheba00.BCrypt.UpdatableBCrypt;
import com.cheba00.models.User;
import com.cheba00.repositories.UserRepository;
import com.cheba00.repositories.UserRepositoryInMemoryImpl;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/signUp")
public class SignUpSerlet extends HttpServlet {
    private UserRepository userRepository;


    @Override
    public void init() throws ServletException {
        this.userRepository = new UserRepositoryInMemoryImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userRepository.findAll();
        req.setAttribute("usersFromServer", users);
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/signUp.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));

        //       hashing the password

        UpdatableBCrypt updatableBCrypt = new UpdatableBCrypt();
        String pw_hash = updatableBCrypt.hash(password);
        User user = new User(name, pw_hash, birthDate);
        userRepository.save(user);
        doGet(req, resp);
    }
}
