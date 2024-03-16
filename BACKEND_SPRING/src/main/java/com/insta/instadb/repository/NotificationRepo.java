package com.insta.instadb.repository;

import com.insta.instadb.entity.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepo extends JpaRepository<Notifications, Long> {

    List<Notifications> findAllByUser_UserId(Long userId);
    void deleteNotificationsByUser_UserId(Long userId);
}
