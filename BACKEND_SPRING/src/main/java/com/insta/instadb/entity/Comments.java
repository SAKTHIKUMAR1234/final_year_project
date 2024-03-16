package com.insta.instadb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

@Setter
@Getter
@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comId;

    @Column
    private String commentContent;

    @ManyToOne
    private Media media;

    @ManyToOne
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column
    private Timestamp timestamp;
}
