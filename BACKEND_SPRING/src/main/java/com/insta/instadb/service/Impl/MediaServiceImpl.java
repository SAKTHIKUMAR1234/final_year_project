package com.insta.instadb.service.Impl;

import com.insta.instadb.dto.MediaDTO;
import com.insta.instadb.entity.*;
import com.insta.instadb.repository.service.InterestRepoService;
import com.insta.instadb.repository.service.MediaRepoService;
import com.insta.instadb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MediaServiceImpl implements MediaService {

    String IMG_FOLDER_PATH = "/home/divum/IdeaProjects/InstaDB/src/main/resources/static/images/";
    String VID_FOLDER_PATH = "/home/divum/IdeaProjects/InstaDB/src/main/resources/static/images/";
    @Autowired
    private MediaRepoService mediaRepoService;
    @Autowired
    private InterestRepoService interestRepoService;
    @Autowired
    private LikesService likesService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private ConnectionService connectionService;
    @Autowired
    private NotificationService notificationService;

    @Override
    public ResponseEntity<?> saveMedia(MultipartFile file, Long userId, List<String> interests, String description, String scheduledTime) throws IOException, ParseException {
        System.out.println(interests);
        List<Interests> interestsList = new ArrayList<>();
        List<Connectiondetails> connectionList = connectionService.getFollowers(userId);

        for (Connectiondetails connectiondetails : connectionList) {
            Notifications notifications = new Notifications();
            notifications.setContent(connectiondetails.getReceiver().getUserName() + " added a new post");
            notifications.setUser(new User(connectiondetails.getSender().getUserId()));
            notificationService.saveNotifications(notifications);
        }
        for (int i = 0; i < interests.size(); i++) {
            interestsList.add(interestRepoService.getInterestbyName(interests.get(i)));
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime parsedDateTime = LocalDateTime.parse(scheduledTime, formatter);
        System.out.println(parsedDateTime);
        String filePath;
        if (Objects.requireNonNull(file.getContentType()).startsWith("image/")) {
            filePath = IMG_FOLDER_PATH + file.getOriginalFilename();
            Media media = new Media(file.getOriginalFilename(), file.getContentType(), description, parsedDateTime, new User(userId), interestsList);
            file.transferTo(new File(filePath));
            return new ResponseEntity<>(mediaRepoService.save(media), HttpStatus.OK);
        } else {
            filePath = VID_FOLDER_PATH + file.getOriginalFilename();
            Media media = new Media(file.getOriginalFilename(), file.getContentType(), description, parsedDateTime, new User(userId), interestsList);
            file.transferTo(new File(filePath));
            return new ResponseEntity<>(mediaRepoService.save(media), HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<?> getMediaByUser(Long userId) {
        List<Media> mediaList = mediaRepoService.findMediaByUser_Id(userId);
        List<MediaDTO> responseList = new ArrayList<>();
        for (Media media : mediaList) {
            List<Comments> commentsList = commentService.getCommentByMedia(media.getId());

            Long count = likesService.getLikesCountByMedia(media.getId());

            MediaDTO mediaDTO = new MediaDTO();
            mediaDTO.setMediaContent(media.getMediaPath());
            mediaDTO.setMediaType(media.getMediaType());
            mediaDTO.setUploadedDate(media.getUploadedDate());
            mediaDTO.setTags(media.getInterests());
            mediaDTO.setUsers(media.getUsers());
            mediaDTO.setLikes(count);
            mediaDTO.setComments(commentsList);

            responseList.add(mediaDTO);
        }
        return new ResponseEntity<>(responseList, HttpStatus.OK);
//            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/jpeg")).body(responseList.get(0).getMediaContent());
    }

    @Override
    public ResponseEntity<?> addInterests(String interests) {
        String[] str = interests.split("\\s+");
        for (String s : str) {
            interestRepoService.save(new Interests(s));
        }
        return new ResponseEntity<>("Interest Saved!!!", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getCount(Long userId) {
        return new ResponseEntity<>(mediaRepoService.findMediaCount(userId), HttpStatus.OK);
    }

    @Override
    public Optional<Media> getMediaById(Long id) {
        return mediaRepoService.findMediaById(id);
    }
}
