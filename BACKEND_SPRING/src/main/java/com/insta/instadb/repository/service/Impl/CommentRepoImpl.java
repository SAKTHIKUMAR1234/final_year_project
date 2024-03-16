package com.insta.instadb.repository.service.Impl;

import com.insta.instadb.entity.Comments;
import com.insta.instadb.repository.CommentRepo;
import com.insta.instadb.repository.service.CommentRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentRepoImpl implements CommentRepoService {

    @Autowired
    private CommentRepo commentRepo;

    @Override
    public void save(Comments comments) {
        commentRepo.save(comments);
    }

    @Override
    public List<Comments> getComment(Long id) {
        System.out.println(id);
        return commentRepo.findAllByMedia_Id(id);
    }
}
