package com.insta.instadb.repository;

import com.insta.instadb.entity.Chats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepo extends JpaRepository<Chats, Long> {

    List<Chats> findAllByUser1_UserIdAndUser2_UserId(Long id1, Long id2);

}
