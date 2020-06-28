package com.cheba00.db.dao;

import com.cheba00.db.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersDaoJdbcImpl implements UserDao {

    private Connection connection;
    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT *FROM fix_user WHERE id = ?";
    //language=SQL
    private  final String SQL_SELECT_ALL = "SELECT * FROM fix_user";

    public UsersDaoJdbcImpl(DataSource dataSource) throws SQLException {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }

    @Override
    public List<User> findAllByFirstName(String name) {
        return null;
    }

    @Override
    public Optional<User> find(Integer id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);

            ResultSet rs = preparedStatement.executeQuery(SQL_SELECT_ALL);
            if (rs.next()) {
                // get user from result set(database)
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                //create user
                return Optional.of(new User(id, firstName, lastName));
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return Optional.empty();
    }



    @Override
    public void save(User model) {

    }

    @Override
    public void update(User model) {

    }

    @Override
    public void delete(Integer model) {

    }

    @Override
    public List<User> findAll() {
        try {
            List<User> users = new ArrayList<>();
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL);
            while (rs.next()) {
                // get user from result set(database)
                Integer id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                //create user
                User user = new User(id, firstName, lastName);

                users.add(user);
            }
            return users;

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
