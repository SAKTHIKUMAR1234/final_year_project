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
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Notifications {
    @Id
    @GeneratedValue
    private Long id;

    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Timestamp createdTime;
    @JsonIgnore
    @ManyToOne
    private User user;

    public Notifications(String content, User user) {
        this.content = content;
        this.user = user;
    }
}
