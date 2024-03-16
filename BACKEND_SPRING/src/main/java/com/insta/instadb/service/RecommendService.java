package com.insta.instadb.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface RecommendService {
    ResponseEntity<?> getRecommendUsers(Long userId);

    ResponseEntity<?> getRecommendMedia(Long userId);
}
