package com.insta.instadb.controller;

import com.insta.instadb.api.RecommendationApi;
import com.insta.instadb.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class RecommendController implements RecommendationApi {

    @Autowired
    private RecommendService recommendService;

    @Override
    public ResponseEntity<?> reCommend(Long userId) {
        return recommendService.getRecommendUsers(userId);
    }

    @Override
    public ResponseEntity<?> reCommendMedia(Long userId) {
        return recommendService.getRecommendMedia(userId);
    }
}
