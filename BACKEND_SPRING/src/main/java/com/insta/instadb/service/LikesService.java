package com.insta.instadb.service;

import com.insta.instadb.entity.Likes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface LikesService {

    ResponseEntity<?> saveLikes(Likes likes);

    Long getLikesCountByMedia(Long userId);
}
