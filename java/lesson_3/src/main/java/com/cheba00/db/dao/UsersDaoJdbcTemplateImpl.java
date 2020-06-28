package com.cheba00.db.dao;

import com.cheba00.db.models.Car;
import com.cheba00.db.models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.*;

public class UsersDaoJdbcTemplateImpl implements UserDao {
    private JdbcTemplate template;
    //language=SQL
    private final String SQL_SELECT_BY_FIRST_NAME = "SELECT * FROM fix_user WHERE first_name = ? ";
    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM fix_user";
    //language=SQL
    private final String SQL_SELECT_USERS_WITH_CARS =
            "SELECT fix_user.*, fc.id as car_id, fc.model FROM fix_user  LEFT JOIN fix_car fc on fix_user.id = fc.owner_id WHERE fix_user.id = ?";

    private Map<Integer, User> userHashMap = new HashMap<>();

    public UsersDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<User> rowMapper = (resultSet, i) -> {

        Integer id = resultSet.getInt("id");
        // if userHashMap not have user -> add user with his car
        if (!userHashMap.containsKey(id)) {
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            User user = new User(id, firstName, lastName, new ArrayList<>());
            userHashMap.put(id, user);
        }
        Car car = new Car(resultSet.getString("model"), resultSet.getInt("car_id"), userHashMap.get(id));
        userHashMap.get(id).getCars().add(car);
        return userHashMap.get(id);
    };


    @Override
    public List<User> findAllByFirstName(String name) {

        return template.query(SQL_SELECT_BY_FIRST_NAME, rowMapper, name);
    }

    @Override
    public Optional<User> find(Integer id) {
        template.query(SQL_SELECT_USERS_WITH_CARS, rowMapper, id);
        if (userHashMap.containsKey(id)) {
            return Optional.of(userHashMap.get(id));
        } else return Optional.empty();
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

        return template.query(SQL_SELECT_ALL, rowMapper);
    }
}
