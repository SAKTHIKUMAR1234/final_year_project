package com.insta.instadb.controller;

import com.insta.instadb.api.ChatApi;
import com.insta.instadb.dto.UserChatDTO;
import com.insta.instadb.entity.Chats;
import com.insta.instadb.service.ChatListService;
import com.insta.instadb.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ChatController implements ChatApi {

    @Autowired
    private ChatService chatService;

    @Autowired
    private ChatListService chatListService;

    @Override
    public ResponseEntity<?> addMessage(Chats chats) {
        return chatService.saveChat(chats);
    }

    @Override
    public ResponseEntity<?> getUserChatList(Long userId) {
        System.out.println(userId);
        return chatListService.getChatList(userId);
    }

    @Override
    public ResponseEntity<?> getUserChats(UserChatDTO userChatDTO) {
        return new ResponseEntity<>(chatService.getAllUserChats(userChatDTO), HttpStatus.OK);
    }
}
