package com.insta.instadb.service;

import com.insta.instadb.entity.Comments;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    ResponseEntity<?> saveComment(Comments comments);

    List<Comments> getCommentByMedia(Long id);
}
