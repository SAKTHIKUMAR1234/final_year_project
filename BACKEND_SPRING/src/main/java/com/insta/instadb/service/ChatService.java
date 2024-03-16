package com.insta.instadb.service;

import com.insta.instadb.dto.UserChatDTO;
import com.insta.instadb.entity.Chats;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ChatService {

    ResponseEntity<?> saveChat(Chats chats);

    ResponseEntity<?> getAllUserChats(UserChatDTO userChatDTO);

}
