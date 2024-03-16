package com.insta.instadb.repository.service.Impl;

import com.insta.instadb.entity.Notifications;
import com.insta.instadb.repository.NotificationRepo;
import com.insta.instadb.repository.service.NotificationRepoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationRepoServiceImpl implements NotificationRepoService {

    @Autowired
    private NotificationRepo notificationRepo;

    @Override
    public Notifications save(Notifications notifications) {
        return notificationRepo.save(notifications);
    }

    @Override
    public List<Notifications> findAllNotifications(Long userId) {
        System.out.println(userId);
        return notificationRepo.findAllByUser_UserId(userId);
    }

    @Transactional
    @Override
    public void deleteNotifications(Long userId) {
        notificationRepo.deleteNotificationsByUser_UserId(userId);
    }
}
