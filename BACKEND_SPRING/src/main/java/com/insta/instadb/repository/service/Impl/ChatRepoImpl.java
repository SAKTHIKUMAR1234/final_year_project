package com.insta.instadb.repository.service.Impl;

import com.insta.instadb.dto.UserChatDTO;
import com.insta.instadb.entity.Chats;
import com.insta.instadb.repository.ChatRepo;
import com.insta.instadb.repository.service.ChatRepoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ChatRepoImpl implements ChatRepoService {

    @Autowired
    private ChatRepo chatRepo;

    @Override
    public Chats saveChat(Chats chats) {
        return chatRepo.save(chats);
    }

    @Override
    public List<Chats> getAllChats(UserChatDTO userChatDTO) {
        List<Chats> chatsList = chatRepo.findAllByUser1_UserIdAndUser2_UserId(userChatDTO.getUser1(), userChatDTO.getUser2());
        chatsList.addAll(chatRepo.findAllByUser1_UserIdAndUser2_UserId(userChatDTO.getUser2(), userChatDTO.getUser1()));
        return chatsList;
    }


}
