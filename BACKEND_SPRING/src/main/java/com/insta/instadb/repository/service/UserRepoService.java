package com.insta.instadb.repository.service;

import com.insta.instadb.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserRepoService {
    User save(User user);

    Optional<User> findUserByEmail(String email);

    Optional<User> findByUserId(Long id);

    User isUserNamePresent(String name);

    Optional<User> getUserById(Long userId);

    void deleteUser(Long userId);

    List<User> findByUserName(String username);

    List<User> findAllUsers();
}
