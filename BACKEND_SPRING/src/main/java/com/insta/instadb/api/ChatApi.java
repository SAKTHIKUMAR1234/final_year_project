package com.insta.instadb.api;

import com.insta.instadb.dto.UserChatDTO;
import com.insta.instadb.entity.Chats;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/message")
public interface ChatApi {

    @PostMapping("/addChat")
    ResponseEntity<?> addMessage(@RequestBody Chats chats);

    @PostMapping ("/getChats")
    ResponseEntity<?> getUserChats(@RequestBody UserChatDTO chatDTO);

    @GetMapping("/getChatList/{userId}")
    ResponseEntity<?> getUserChatList(@PathVariable Long userId);
}
