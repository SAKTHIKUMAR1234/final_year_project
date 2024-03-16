package com.insta.instadb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table
@Setter
@Getter
@ToString
public class Connectiondetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conId;


    @Column
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne(fetch = FetchType.EAGER)
    private User sender;

    @ManyToOne(fetch = FetchType.EAGER)
    private User receiver;
}
