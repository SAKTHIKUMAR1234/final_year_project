package com.insta.instadb.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

@Table
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Chats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user1;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user2;

    @Column
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column
    private Timestamp sendDate;
}
