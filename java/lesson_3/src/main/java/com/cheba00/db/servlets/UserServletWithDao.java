package com.cheba00.db.servlets;

import com.cheba00.db.dao.UserDao;
import com.cheba00.db.dao.UsersDaoJdbcImpl;
import com.cheba00.db.dao.UsersDaoJdbcTemplateImpl;
import com.cheba00.db.models.User;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@WebServlet("/users")
public class UserServletWithDao extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        Properties properties = new Properties();
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        try {
            properties.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/db.properties")));
            String dbUrl = properties.getProperty("db.url");
            String dbName = properties.getProperty("db.userName");
            String dbPassword = properties.getProperty("db.userPassword");
            String dbDriverClassName = properties.getProperty("db.driverClassName");

            driverManagerDataSource.setUsername(dbName);
            driverManagerDataSource.setPassword(dbPassword);
            driverManagerDataSource.setDriverClassName(dbDriverClassName);
            driverManagerDataSource.setUrl(dbUrl);

            userDao = new UsersDaoJdbcTemplateImpl(driverManagerDataSource);

        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Optional<User> user = userDao.find(1);
        int i = 0;




        List<User> users;
        if (req.getParameter("firstName" ) != null) {
            String firstName = req.getParameter("firstName");
            users = userDao.findAllByFirstName(firstName);
        } else {
            users = userDao.findAll();
        }
        req.setAttribute("usersFromServer", users);
        req.getServletContext().getRequestDispatcher("/jsp/users.jsp").forward(req, resp);


    }

}
