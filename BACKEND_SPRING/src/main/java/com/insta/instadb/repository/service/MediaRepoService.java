package com.insta.instadb.repository.service;

import com.insta.instadb.entity.Media;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MediaRepoService {
    Media save(Media media);

    List<Media> findMediaByUser_Id(Long userId);

    Long findMediaCount(Long userId);

    List<Media> getAllMedia();

    Optional<Media> findMediaById(Long id);
}
