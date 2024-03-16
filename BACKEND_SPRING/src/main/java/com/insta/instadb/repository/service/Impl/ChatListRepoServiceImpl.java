package com.insta.instadb.repository.service.Impl;

import com.insta.instadb.entity.ChatsList;
import com.insta.instadb.repository.ChatListRepo;
import com.insta.instadb.repository.service.ChatListRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatListRepoServiceImpl implements ChatListRepoService {

    @Autowired
    private ChatListRepo chatListRepo;

    @Override
    public ChatsList saveChatInfo(ChatsList chatsList) {
        return chatListRepo.save(chatsList);
    }

    @Override
    public boolean checkChat(Long userId, Long userId1) {
        Optional<ChatsList> chatsList = chatListRepo.findChatsListByUser1_UserIdAndUser2_UserId(userId, userId1);
        if (chatsList.isEmpty())
            return true;
        return false;
    }

    @Override
    public List<ChatsList> getUserChatList(Long userId) {
        List<ChatsList> chatsLists = chatListRepo.findChatsListsByUser1UserIdOrderByDateDesc(userId);
        return chatsLists;
    }
}
