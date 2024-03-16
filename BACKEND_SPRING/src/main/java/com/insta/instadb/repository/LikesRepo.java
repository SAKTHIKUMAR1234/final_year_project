package com.insta.instadb.repository;

import com.insta.instadb.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikesRepo extends JpaRepository<Likes, Long> {

    Long countLikesByMedia_Id(Long mediaId);

    Optional<Likes> findLikesByMedia_IdAndUser_UserId(Long mediaId, Long userId);
}
