package com.cheba00.servlets;

import com.cheba00.repositories.UserRepository;
import com.cheba00.repositories.UserRepositoryInMemoryImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(req, resp);

    }

    private UserRepository userRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.userRepository = new UserRepositoryInMemoryImpl();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if (userRepository.isExist(name, password)) {
            HttpSession session = req.getSession(false);
            session.setAttribute("user", name);
            req.getServletContext().getRequestDispatcher("/home").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath()+"/login");
        }

    }
}

