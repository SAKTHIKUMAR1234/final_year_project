package com.insta.instadb.api;

import com.insta.instadb.entity.Likes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/likes")
public interface LikesApi {
    @PostMapping("/addLike")
    ResponseEntity<?> addLike(@RequestBody Likes likes);
}
