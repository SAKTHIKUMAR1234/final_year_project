package com.insta.instadb.repository.service;

import com.insta.instadb.entity.Interests;
import org.springframework.stereotype.Service;

@Service
public interface InterestRepoService {

    void save(Interests interests);

    Interests getInterestbyName(String s);
}
