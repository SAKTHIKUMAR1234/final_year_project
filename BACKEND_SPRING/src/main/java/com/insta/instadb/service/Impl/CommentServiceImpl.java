package com.insta.instadb.service.Impl;

import com.insta.instadb.entity.Comments;
import com.insta.instadb.repository.service.CommentRepoService;
import com.insta.instadb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepoService commentRepoService;

    @Override
    public ResponseEntity<?> saveComment(Comments comments) {
        commentRepoService.save(comments);
        return new ResponseEntity<>("Comment Posted", HttpStatus.OK);
    }

    @Override
    public List<Comments> getCommentByMedia(Long id) {
        return commentRepoService.getComment(id);
    }
}
