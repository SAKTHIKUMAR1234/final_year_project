package com.insta.instadb.service.Impl;

import com.insta.instadb.entity.Notifications;
import com.insta.instadb.repository.service.NotificationRepoService;
import com.insta.instadb.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepoService notificationRepoService;

    @Override
    public ResponseEntity<?> saveNotifications(Notifications notifications) {
        return new ResponseEntity<>(notificationRepoService.save(notifications), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getNotifications(Long userId) {
        return new ResponseEntity<>(notificationRepoService.findAllNotifications(userId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> removeNotification(Long userId) {
        notificationRepoService.deleteNotifications(userId);
        return new ResponseEntity<>("Notifications Deleted !!!", HttpStatus.OK);
    }
}
