package com.insta.instadb.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/api/v1/notifyUser")
public interface NotificationApi {
    @GetMapping("/getNotifications/{userId}")
    ResponseEntity<?> getNotificationforUser(@PathVariable Long userId);

    @DeleteMapping("/clearNotifications/{userId}")
    ResponseEntity<?> clearNotificationsforUser(@PathVariable Long userId);
}
