package com.cheba00.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.cheba00.models.Car;
import com.cheba00.models.User;

import java.util.List;


/**
 * 04.04.2018
 * ru.ivmiit.app.Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Application {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://35.226.243.75/bet_helper");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "12345");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.addResource("User.hbm.xml");
        configuration.addAnnotatedClass(Car.class);
        configuration.setProperty("hibernate.show_sql", "true");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        //language=HQL

        User user = session.createQuery("from User user where user.id = 1", User.class).getSingleResult();

        session.beginTransaction();
        session.save(new User("Mini", "Max", 99));
        session.getTransaction().commit();
        System.out.println(user);
        //language=HQL
        List<Car> car = session.createQuery("from Car car", Car.class).getResultList();

        int i = 0;

    }
}