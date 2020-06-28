package com.cheba00.db.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

//@WebServlet("/users")
public class UsersServlet extends HttpServlet {

    private  Connection connection;
    @Override
    public void init() throws ServletException {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/db.properties")));
            String dbUrl = properties.getProperty("db.url");
            String dbName = properties.getProperty("db.userName");
            String dbPassword = properties.getProperty("db.userPassword");
            String dbDriverClassName = properties.getProperty("db.driverClassName");

            Class.forName(dbDriverClassName);

            connection = DriverManager.getConnection(dbUrl, dbName, dbPassword);
        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/addUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        try{
//            Statement statement = connection.createStatement();
//            String sqlInsert = "INSERT INTO fix_user(first_name,last_name) " +
//                    "VALUES ('" + firstName + "', '" + lastName + "')";
//            System.out.println(sqlInsert);
//            statement.execute(sqlInsert);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO fix_user(first_name, last_name) VALUES (?,?)");
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
