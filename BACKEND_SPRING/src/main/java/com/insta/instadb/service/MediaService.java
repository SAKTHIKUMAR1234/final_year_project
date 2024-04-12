package com.insta.instadb.service;

import com.insta.instadb.entity.Media;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public interface MediaService {
    ResponseEntity<?> saveMedia(MultipartFile file, Long userId, List<String> interests, String description, String scheduledTime) throws IOException, ParseException;

    ResponseEntity<?> getMediaByUser(Long userId) throws IOException;

    ResponseEntity<?> addInterests(String interests);

    ResponseEntity<?> getCount(Long userId);

    Optional<Media> getMediaById(Long id);

    ResponseEntity<?> getInterestCount();
}
