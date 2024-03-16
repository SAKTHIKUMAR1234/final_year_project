package com.insta.instadb.controller;

import com.insta.instadb.api.ConnectionApi;
import com.insta.instadb.dto.ConnectionDTO;
import com.insta.instadb.entity.Connectiondetails;
import com.insta.instadb.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ConnectionController implements ConnectionApi {

    @Autowired
    private ConnectionService connectionService;

    @Override
    public ResponseEntity<?> followRequest(Connectiondetails connectiondetails) {
        return connectionService.addRequest(connectiondetails);
    }

    @Override
    public ResponseEntity<?> removeFollowRequest(ConnectionDTO connectionDTO) {
        return connectionService.removeFollow(connectionDTO);
    }

    @Override
    public ResponseEntity<?> requestedList(Long userId) {
        return connectionService.getRequests(userId);
    }

    @Override
    public ResponseEntity<?> acceptedFollowRequest(ConnectionDTO connectionDTO) {
        return connectionService.acceptRequest(connectionDTO);
    }

    @Override
    public ResponseEntity<?> rejectedFollowRequest(ConnectionDTO connectionDTO) {
        return connectionService.rejectRequest(connectionDTO);
    }

    @Override
    public ResponseEntity<?> followersandfollwingCount(Long userId) {
        return new ResponseEntity<>(connectionService.getFollowersCount(userId) + " " +
                connectionService.getFollowingCount(userId), HttpStatus.OK);
    }
}
