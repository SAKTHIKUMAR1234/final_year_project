package com.insta.instadb.controller;

import com.insta.instadb.api.CommentApi;
import com.insta.instadb.entity.Comments;
import com.insta.instadb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class CommentController implements CommentApi {
    @Autowired
    private CommentService commentService;

    @Override
    public ResponseEntity<?> addComment(Comments comments) {
        return commentService.saveComment(comments);
    }
}
