package com.insta.instadb.repository;

import com.insta.instadb.entity.ChatsList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatListRepo extends JpaRepository<ChatsList, Long> {

    Optional<ChatsList> findChatsListByUser1_UserIdAndUser2_UserId(Long user1, Long user2);


    List<ChatsList> findChatsListsByUser1UserIdOrderByDateDesc(Long user1UserId);
}
