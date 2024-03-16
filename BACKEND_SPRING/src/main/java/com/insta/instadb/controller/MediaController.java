package com.insta.instadb.controller;

import com.insta.instadb.api.MediaApi;
import com.insta.instadb.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@CrossOrigin
@RestController
public class MediaController implements MediaApi {

    @Autowired
    private MediaService mediaService;

    @Override
    public ResponseEntity<?> addNewMedia(MultipartFile file,
                                         Long userId,
                                         List<String> interests,
                                         String description,
                                         String scheduledTime) throws IOException, ParseException {
        return mediaService.saveMedia(file, userId, interests, description, scheduledTime);
    }

    @Override
    public ResponseEntity<?> getMediaByUser(Long userId) throws IOException {
        return mediaService.getMediaByUser(userId);
    }

    @Override
    public ResponseEntity<?> getMediaCount(Long userId) {
        return mediaService.getCount(userId);
    }

    @Override
    public ResponseEntity<?> addInterest(String interests) {
        System.out.println(interests);
        return mediaService.addInterests(interests);
    }
}
