package com.insta.instadb.service;

import com.insta.instadb.dto.LoginDTO;
import com.insta.instadb.dto.UpdateUserDTO;
import com.insta.instadb.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    ResponseEntity<?> saveNewUser(User user);

    ResponseEntity<?> updateUserDetails(UpdateUserDTO updateUserDTO);

    boolean checkIfUser(String email);

    Optional<User> findUserById(Long userId);

    ResponseEntity<?> validateUserName(String name);

    ResponseEntity<?> authorizeUser(LoginDTO loginDTO);

    ResponseEntity<?> getFriendsList(Long userId);

    ResponseEntity<?> getUser(Long userId);

    ResponseEntity<?> removeAccount(Long userId);

    ResponseEntity<?> Oauthorize(String email);

    ResponseEntity<?> findUsersByUsername(String username);

    ResponseEntity<?> checkDbIsNull();


}
