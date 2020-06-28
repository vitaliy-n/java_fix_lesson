package com.cheba00.fake;

import com.cheba00.models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FakeStorage {
    private static final FakeStorage storage;

    static {
        storage = new FakeStorage();

    }

    public List<User> users;

    public FakeStorage() {
        this.users = new ArrayList<>();
        User user = new User("Vitaliy", "1", LocalDate.parse("2000-02-28"));
        User user2 = new User("Vitaliy2", "123", LocalDate.parse("2000-02-28"));
        User user3 = new User("Vitaliy3", "321", LocalDate.parse("2000-02-28"));

        users.add(user);
        users.add(user2);
        users.add(user3);
    }

    public static FakeStorage storage() {
        return storage;
    }

    public List<User> users() {
        return users;
    }
}
