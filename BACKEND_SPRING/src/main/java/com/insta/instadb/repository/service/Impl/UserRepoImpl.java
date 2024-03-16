package com.insta.instadb.repository.service.Impl;

import com.insta.instadb.entity.User;
import com.insta.instadb.repository.UserRepo;
import com.insta.instadb.repository.service.UserRepoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserRepoImpl implements UserRepoService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public Optional<User> findByUserId(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public User isUserNamePresent(String name) {
        return userRepo.findByUserName(name);
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return userRepo.findById(userId);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public List<User> findByUserName(String username) {
        return userRepo.findUsersByUserNameContainingIgnoreCase(username);
    }


}
