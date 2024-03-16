package com.insta.instadb.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

@Embeddable
public class UserInterests {

    @ManyToOne
    private User user;

    @ManyToOne
    private Interests interests;

}
