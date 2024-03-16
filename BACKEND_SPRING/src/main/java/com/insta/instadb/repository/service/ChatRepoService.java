package com.insta.instadb.repository.service;

import com.insta.instadb.dto.UserChatDTO;
import com.insta.instadb.entity.Chats;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChatRepoService {
    Chats saveChat(Chats chats);

    List<Chats> getAllChats(UserChatDTO userChatDTO);


}
