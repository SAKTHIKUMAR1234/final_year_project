package com.insta.instadb.service;

import com.insta.instadb.dto.ConnectionDTO;
import com.insta.instadb.entity.Connectiondetails;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConnectionService {
    ResponseEntity<?> addRequest(Connectiondetails connectiondetails);

    ResponseEntity<?> isFollower(Long sender, Long receiver);

    List<Connectiondetails> getFollowers(Long userId);

    Long getFollowersCount(Long userId);

    Long getFollowingCount(Long userId);

    List<Connectiondetails> findFriends(Long userId);

    ResponseEntity<?> removeFollow(ConnectionDTO connectionDTO);

    ResponseEntity<?> acceptRequest(ConnectionDTO connectionDTO);

    ResponseEntity<?> rejectRequest(ConnectionDTO connectionDTO);

    ResponseEntity<?> getRequests(Long userId);
}
