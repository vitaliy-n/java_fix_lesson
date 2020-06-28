package com.cheba00.mvc.repositories;

import com.cheba00.mvc.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository  extends JpaRepository<User, Long> {
        List<User> findAllByFirstName(String firstName);
}
