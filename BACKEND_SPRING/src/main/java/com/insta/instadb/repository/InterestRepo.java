package com.insta.instadb.repository;

import com.insta.instadb.entity.Interests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestRepo extends JpaRepository<Interests, Long> {
    Interests findInterestsByContent(String s);

}
