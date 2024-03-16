package com.insta.instadb.controller;

import com.insta.instadb.api.LikesApi;
import com.insta.instadb.entity.Likes;
import com.insta.instadb.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class LikesController implements LikesApi {

    @Autowired
    private LikesService likesService;

    @Override
    public ResponseEntity<?> addLike(Likes likes) {
        return likesService.saveLikes(likes);
    }
}
