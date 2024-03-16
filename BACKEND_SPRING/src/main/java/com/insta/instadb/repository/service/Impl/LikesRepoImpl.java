package com.insta.instadb.repository.service.Impl;

import com.insta.instadb.entity.Likes;
import com.insta.instadb.repository.LikesRepo;
import com.insta.instadb.repository.service.LikesRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikesRepoImpl implements LikesRepoService {

    @Autowired
    private LikesRepo likesRepo;

    @Override
    public Likes save(Likes likes) {
        return likesRepo.save(likes);
    }

    @Override
    public Long findLikesCountByMedia(Long userId) {
        System.out.println(userId + "likes");
        return likesRepo.countLikesByMedia_Id(userId);
    }

    @Override
    public boolean isLiked(Long mediaId, Long userId) {
        Optional<Likes> likes = likesRepo.findLikesByMedia_IdAndUser_UserId(mediaId,userId);
        return likes.isPresent();
    }
}
