package com.insta.instadb.api;

import com.insta.instadb.dto.LoginDTO;
import com.insta.instadb.dto.UpdateUserDTO;
import com.insta.instadb.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/userdetails")
public interface UserApi {
    @PostMapping("/newUser")
    ResponseEntity<?> newUser(@RequestBody User user);

    @PutMapping("/updateUser")
    ResponseEntity<?> updateUser(@RequestBody UpdateUserDTO updateUserDTO);

    @DeleteMapping("/deleteUser/{userId}")
    ResponseEntity<?> deleteUser(@PathVariable Long userId);

    @GetMapping("/searchUser/{username}")
    ResponseEntity<?> getUserByName(@PathVariable String username);

    @GetMapping("/getUser/{userId}")
    ResponseEntity<?> getUser(@PathVariable Long userId);

    @GetMapping("/isUser/{name}")
    ResponseEntity<?> checkUserName(@PathVariable String name);

    @PostMapping("/loginAuth")
    ResponseEntity<?> authUser(@RequestBody LoginDTO loginDTO);

    @PostMapping("/oauthUser/{email}")
    ResponseEntity<?> oAuth(@PathVariable String email);

    @GetMapping("/getFriendsList/{userId}")
    ResponseEntity<?> friendsList(@PathVariable Long userId);

    @GetMapping("/forgotPassword/{email}")
    ResponseEntity<?> getResetLink(@PathVariable String email);
}
