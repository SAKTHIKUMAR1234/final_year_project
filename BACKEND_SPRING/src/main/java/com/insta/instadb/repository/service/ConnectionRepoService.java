package com.insta.instadb.repository.service;

import com.insta.instadb.dto.ConnectionDTO;
import com.insta.instadb.entity.Connectiondetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ConnectionRepoService {

    Connectiondetails saveFollowRequest(Connectiondetails connectiondetails);

    Optional<Connectiondetails> findBySenderandReceiver(Long sender, Long receiver);

    Long getFrCount(Long userId);

    Long getFgCount(Long userId);

    Connectiondetails changeStatus(ConnectionDTO connectionDTO);

    List<Connectiondetails> findFriendsList(Long userId);

    List<Connectiondetails> getAllFollowers(Long userId);

    String removeFollowRequest(ConnectionDTO connectionDTO);

    List<Connectiondetails> getRequestConnection(Long userId);
}
