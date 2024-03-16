package com.insta.instadb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

@Entity
@Table(name = "media_likes")
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;

    @ManyToOne
    private Media media;

    @ManyToOne
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Timestamp likedDate;
}
