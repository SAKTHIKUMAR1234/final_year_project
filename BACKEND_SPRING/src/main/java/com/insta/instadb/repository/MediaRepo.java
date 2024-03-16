package com.insta.instadb.repository;

import com.insta.instadb.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediaRepo extends JpaRepository<Media, Long> {

    List<Media> findAllByUsers_UserId(Long userId);

    Long countAllByUsers_UserId(Long userId);

}
