package com.insta.instadb.service;

import com.insta.instadb.entity.Notifications;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface NotificationService {

    ResponseEntity<?> saveNotifications(Notifications notifications);

    ResponseEntity<?> getNotifications(Long userId);

    ResponseEntity<?> removeNotification(Long userId);
}
