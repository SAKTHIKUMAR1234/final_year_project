package com.insta.instadb.repository.service;

import com.insta.instadb.entity.Comments;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentRepoService {
    void save(Comments comments);

    List<Comments> getComment(Long id);
}
