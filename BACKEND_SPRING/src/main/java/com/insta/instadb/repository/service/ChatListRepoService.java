package com.insta.instadb.repository.service;

import com.insta.instadb.entity.ChatsList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChatListRepoService {
    ChatsList saveChatInfo(ChatsList chatsList);

    boolean checkChat(Long userId, Long userId1);

    List<ChatsList> getUserChatList(Long userId);
}
