package com.insta.instadb.service.Impl;

import com.insta.instadb.entity.ChatsList;
import com.insta.instadb.entity.User;
import com.insta.instadb.repository.service.ChatListRepoService;
import com.insta.instadb.service.ChatListService;
import com.insta.instadb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ChatListServiceImpl implements ChatListService {

    @Autowired
    private UserService userService;

    @Autowired
    private ChatListRepoService chatListRepoService;

    @Override
    public void saveChatList(User user1, User user2) {

        if (chatListRepoService.checkChat(user1.getUserId(), user2.getUserId())) {
            User sender = userService.findUserById(user1.getUserId()).get();
            User receiver = userService.findUserById(user2.getUserId()).get();
            String avtext = receiver.getFirstName().charAt(0) + "" + receiver.getLastName().charAt(0);
            ChatsList chatsList = new ChatsList();
            chatsList.setUser1(user1);
            chatsList.setUser2(user2);
            chatsList.setAvatarColor("red");
            chatsList.setAvatarText(avtext.toUpperCase());
            chatsList.setLastMessage("How are you???");
            chatListRepoService.saveChatInfo(chatsList);


            avtext = sender.getFirstName().charAt(0) + "" + sender.getLastName().charAt(0);
            ChatsList chatsList1 = new ChatsList();
            chatsList1.setUser1(user2);
            chatsList1.setUser2(user1);
            chatsList1.setAvatarColor("red");
            chatsList1.setAvatarText(avtext.toUpperCase());
            chatsList1.setLastMessage("How are you???");
            chatListRepoService.saveChatInfo(chatsList1);
        }
    }

    @Override
    public ResponseEntity<?> getChatList(Long userId) {
        return new ResponseEntity<>(chatListRepoService.getUserChatList(userId), HttpStatus.OK);
    }
}
