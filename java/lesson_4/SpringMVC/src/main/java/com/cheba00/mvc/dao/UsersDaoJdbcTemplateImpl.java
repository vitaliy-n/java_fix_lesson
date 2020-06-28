package com.cheba00.mvc.dao;

import com.cheba00.mvc.models.Car;
import com.cheba00.mvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.*;

@Component
public class UsersDaoJdbcTemplateImpl implements UserDao {
    private JdbcTemplate template;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //language=SQL
    private final String SQL_SELECT_BY_FIRST_NAME = "SELECT * from fix_user where fix_user.first_name = ? ";
    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM fix_user left join fix_car fc on fix_user.id = fc.owner_id";
    //language=SQL
    private final String SQL_SELECT_USERS_WITH_CARS =
            "SELECT fix_user.*, fc.id as car_id, fc.model FROM fix_user  LEFT JOIN fix_car fc on fix_user.id = fc.owner_id WHERE fix_user.id = ?";
    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM fix_user WHERE fix_user.id = :id";

    //language=SQL
    private final String SQL_INSERT_USER = "INSERT INTO fix_user(FIRST_NAME, LAST_NAME) VALUES (:firstName, :lastName)";


    private Map<Long, User> userHashMap = new HashMap<>();

    @Autowired
    public UsersDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private RowMapper<User> rowMapperWithoutCar = (resultSet, i) -> User.builder()
            .id(resultSet.getLong("id"))
            .firstName(resultSet.getString("first_name"))
            .lastName(resultSet.getString("last_name")).build();


    private RowMapper<User> rowMapper = (resultSet, i) -> {

        Long id = resultSet.getLong("id");
        // if userHashMap not have user -> add user with his car
        if (!userHashMap.containsKey(id)) {
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            User user = new User(id,
                    firstName,
                    lastName,
                    new ArrayList<>());
            userHashMap.put(id, user);
        }


        Car car = new Car(resultSet.getLong("id"), resultSet.getString("model"), userHashMap.get(id));
        userHashMap.get(id).getCars().add(car);
        return userHashMap.get(id);
    };


    @Override
    public List<User> findAllByFirstName(String name) {

        return template.query(SQL_SELECT_BY_FIRST_NAME, rowMapperWithoutCar, name);
    }

    @Override
    public Optional<User> find(Long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        List<User> result = namedParameterJdbcTemplate.query(SQL_SELECT_BY_ID, params, rowMapperWithoutCar);
        if (result.isEmpty()) {
            return Optional.empty();
        }else
        return Optional.of(result.get(0));
    }

    @Override
    public void save(User model) {
        Map<String, Object>  params = new HashMap<>();
        params.put("firstName", model.getFirstName());
        params.put("lastName", model.getLastName());
        namedParameterJdbcTemplate.update(SQL_INSERT_USER, params);

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
