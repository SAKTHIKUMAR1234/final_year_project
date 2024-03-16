package com.insta.instadb.repository;

import com.insta.instadb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    User findByUserName(String name);

    List<User> findUsersByUserNameContainingIgnoreCase(String username);
}
