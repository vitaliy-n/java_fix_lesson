package com.cheba00.repositories;

import com.cheba00.BCrypt.UpdatableBCrypt;
import com.cheba00.fake.FakeStorage;
import com.cheba00.models.User;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.List;

public class UserRepositoryInMemoryImpl implements UserRepository{

     public List<User> findAll() {
        return FakeStorage.storage().users;
    }

    @Override
    public void save(User user) {
        FakeStorage.storage().users.add(user);
    }

    @Override
    public boolean isExist(String name, String password) {
        UpdatableBCrypt updatableBCrypt = new UpdatableBCrypt();
        for (User user : FakeStorage.storage().users) {
            if ((user.getName().equals(name) && (updatableBCrypt.verifyHash(password, user.getPassword())))){
                return true;
            }
        }
        return false;
    }
}
