package com.insta.instadb.repository.service;

import com.insta.instadb.entity.Notifications;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotificationRepoService {

    Notifications save(Notifications notifications);

    List<Notifications> findAllNotifications(Long userId);

    void deleteNotifications(Long userId);
}
