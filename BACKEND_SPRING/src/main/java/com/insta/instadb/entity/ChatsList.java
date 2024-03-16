package com.insta.instadb.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ChatsList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    private User user1;

    @ManyToOne
    private User user2;

    @Column
    private String avatarColor;

    @Column
    private String avatarText;

    @Column
    private String lastMessage;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Timestamp date;
}
