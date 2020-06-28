package com.cheba00.BCrypt;

import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.function.Function;

public class UpdatableBCrypt {


    public String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean verifyHash(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }


}