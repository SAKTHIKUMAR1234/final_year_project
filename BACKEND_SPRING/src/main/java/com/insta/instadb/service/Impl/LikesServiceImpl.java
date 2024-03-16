package com.insta.instadb.service.Impl;

import com.insta.instadb.entity.Interests;
import com.insta.instadb.entity.Likes;
import com.insta.instadb.entity.Media;
import com.insta.instadb.entity.User;
import com.insta.instadb.repository.service.LikesRepoService;
import com.insta.instadb.repository.service.UserRepoService;
import com.insta.instadb.service.LikesService;
import com.insta.instadb.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LikesServiceImpl implements LikesService {

    @Autowired
    private LikesRepoService likesRepoService;

    @Autowired
    private UserRepoService userRepoService;
    @Autowired
    private MediaService mediaService;

    @Override
    public ResponseEntity<?> saveLikes(Likes likes) {
        User user = userRepoService.findByUserId(likes.getUser().getUserId()).get();
        Optional<Media> media = mediaService.getMediaById(likes.getMedia().getId());

        if (media.isPresent()) {
            List<Interests> userInterest = user.getInterests();
            userInterest.addAll(media.get().getInterests());

            Map<Long, Interests> interestsMap = new HashMap<>();
            for (Interests interests : userInterest) {
                if (!interestsMap.containsKey(interests.getInterestId())) {
                    interestsMap.put(interests.getInterestId(), interests);
                }
            }
            user.setInterests(new ArrayList<>(interestsMap.values()));
            userRepoService.save(user);
//            System.out.println();

        }
        return new ResponseEntity<>(likesRepoService.save(likes), HttpStatus.OK);
    }

    @Override
    public Long getLikesCountByMedia(Long userId) {
        return likesRepoService.findLikesCountByMedia(userId);
    }
}
