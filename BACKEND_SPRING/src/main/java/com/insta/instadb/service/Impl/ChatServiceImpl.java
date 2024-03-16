package com.insta.instadb.service.Impl;

import com.insta.instadb.dto.UserChatDTO;
import com.insta.instadb.entity.Chats;
import com.insta.instadb.repository.service.ChatRepoService;
import com.insta.instadb.service.ChatListService;
import com.insta.instadb.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatRepoService chatRepoService;

    @Autowired
    private ChatListService chatListService;

    @Override
    public ResponseEntity<?> saveChat(Chats chats) {
        chatListService.saveChatList(chats.getUser1(), chats.getUser2());
        return new ResponseEntity<>(chatRepoService.saveChat(chats), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllUserChats(UserChatDTO userChatDTO) {
        Map<Long, Chats> chatsMap = new TreeMap<>();
        List<Chats> chatsList = chatRepoService.getAllChats(userChatDTO);
        for (Chats chats : chatsList) {
            chatsMap.put(chats.getId(), chats);
        }
        return new ResponseEntity<>(chatsMap, HttpStatus.OK);
    }


}
