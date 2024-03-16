package com.insta.instadb.controller;

import com.insta.instadb.api.UserApi;
import com.insta.instadb.dto.LoginDTO;
import com.insta.instadb.dto.UpdateUserDTO;
import com.insta.instadb.entity.User;
import com.insta.instadb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserController implements UserApi {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<?> newUser(User user) {
        return new ResponseEntity<>(userService.saveNewUser(user), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateUser(UpdateUserDTO updateUserDTO) {
        return userService.updateUserDetails(updateUserDTO);
    }

    @Override
    public ResponseEntity<?> deleteUser(Long userId) {
        return userService.removeAccount(userId);
    }

    @Override
    public ResponseEntity<?> getUserByName(String username) {
        return new ResponseEntity<>(userService.findUsersByUsername(username), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getUser(Long userId) {
        return userService.getUser(userId);
    }

    @Override
    public ResponseEntity<?> checkUserName(String name) {
        return userService.validateUserName(name);
    }

    @Override
    public ResponseEntity<?> authUser(LoginDTO loginDTO) {
        return userService.authorizeUser(loginDTO);
    }

    @Override
    public ResponseEntity<?> oAuth(String email) {
        return userService.Oauthorize(email);
    }

    @Override
    public ResponseEntity<?> friendsList(Long userId) {
        return userService.getFriendsList(userId);
    }

    @Override
    public ResponseEntity<?> getResetLink(String email) {
        return null;
    }
}
