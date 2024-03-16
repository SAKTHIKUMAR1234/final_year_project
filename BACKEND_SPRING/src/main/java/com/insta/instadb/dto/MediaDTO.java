package com.insta.instadb.dto;

import com.insta.instadb.entity.Comments;
import com.insta.instadb.entity.Interests;
import com.insta.instadb.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediaDTO {

    private String mediaContent;

    private String mediaType;

    private User users;

    private LocalDateTime scheduledTime;

    private String description;

    private Timestamp uploadedDate;

    private List<Interests> tags;

    private Long likes;

    private List<Comments> comments;


}
