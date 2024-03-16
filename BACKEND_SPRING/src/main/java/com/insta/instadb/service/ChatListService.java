package com.insta.instadb.service;

import com.insta.instadb.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ChatListService {

    void saveChatList(User user1, User user2);

    ResponseEntity<?> getChatList(Long userId);

}
