package com.insta.instadb.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String mediaPath;

    @Column
    private String mediaType;

    @Column
    private String description;

    @Column
    private LocalDateTime scheduledTime;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Timestamp uploadedDate;

    @ManyToOne
    private User users;

    @ManyToMany
    @JoinTable(name = "media_tags")
    private List<Interests> interests;


    public Media(String mediaPath, String mediaType, String description, LocalDateTime scheduledTime, User users, List<Interests> interests) {
        this.mediaPath = mediaPath;
        this.mediaType = mediaType;
        this.description = description;
        this.scheduledTime = scheduledTime;
        this.users = users;
        this.interests = interests;
    }
}
