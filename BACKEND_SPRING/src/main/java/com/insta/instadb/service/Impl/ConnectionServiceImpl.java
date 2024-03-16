package com.insta.instadb.service.Impl;

import com.insta.instadb.dto.ConnectionDTO;
import com.insta.instadb.entity.Connectiondetails;
import com.insta.instadb.entity.Notifications;
import com.insta.instadb.entity.Status;
import com.insta.instadb.entity.User;
import com.insta.instadb.repository.service.ConnectionRepoService;
import com.insta.instadb.repository.service.UserRepoService;
import com.insta.instadb.service.ConnectionService;
import com.insta.instadb.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ConnectionServiceImpl implements ConnectionService {

    @Autowired
    private ConnectionRepoService connectionRepoService;

    @Autowired
    private UserRepoService userRepoService;

    @Autowired
    private NotificationService notificationService;

    @Override
    public ResponseEntity<?> addRequest(Connectiondetails connectiondetails) {
        Connectiondetails follower = (Connectiondetails) isFollower(connectiondetails.getSender().getUserId(), connectiondetails.getReceiver().getUserId()).getBody();
        Connectiondetails isfollowing = (Connectiondetails) isFollower(connectiondetails.getReceiver().getUserId(), connectiondetails.getSender().getUserId()).getBody();
        if (follower != null) {
            if ((connectiondetails.getSender().getUserId() == follower.getSender().getUserId()) &&
                    connectiondetails.getReceiver().getUserId() == connectiondetails.getReceiver().getUserId()) {
                return new ResponseEntity<>("Already Followed!!!", HttpStatus.OK);
            }
        }
        User user = userRepoService.findByUserId(connectiondetails.getSender().getUserId()).get();
        User user1 = userRepoService.findByUserId(connectiondetails.getReceiver().getUserId()).get();
        connectiondetails.setCreatedDate(new Date());

        if (follower != null && isfollowing == null) {
            connectiondetails.setStatus(new Status(4L));
            follower.setStatus(new Status(4L));
            Connectiondetails notifyUser = connectionRepoService.saveFollowRequest(follower);
            Connectiondetails userToBeNotified = connectionRepoService.saveFollowRequest(connectiondetails);
            notificationService.saveNotifications(new Notifications(userToBeNotified.getReceiver().getUserName() + " is following you!!!", notifyUser.getSender()));
            return new ResponseEntity<>(userToBeNotified, HttpStatus.OK);

        } else if (follower == null && isfollowing != null) {
            isfollowing.setStatus(new Status(4L));
            connectiondetails.setStatus(new Status(4L));
            Connectiondetails notifyUser = connectionRepoService.saveFollowRequest(isfollowing);
            Connectiondetails userToBeNotified = connectionRepoService.saveFollowRequest(connectiondetails);
            System.out.println(userToBeNotified + " " + userToBeNotified);
            notificationService.saveNotifications(new Notifications(userRepoService.findByUserId(userToBeNotified.getSender().getUserId()).get().getUserName() + " is following you!!!", notifyUser.getSender()));
            return new ResponseEntity<>(userToBeNotified, HttpStatus.OK);
        }
        if (isfollowing == null) {
            if (user.getAccountType().equals("public") && user1.getAccountType().equals("private")) {
                connectiondetails.setStatus(new Status(2L));
                notificationService.saveNotifications(new Notifications(user.getUserName() + " is requested you to follow!!!", user1));
            } else if (user.getAccountType().equals("public") && user1.getAccountType().equals("public")) {
                connectiondetails.setStatus(new Status(1L));
                notificationService.saveNotifications(new Notifications(user.getUserName() + " is following you!!!", user1));
            } else if (user.getAccountType().equals("private") && user1.getAccountType().equals("private")) {
                connectiondetails.setStatus(new Status(2L));
                notificationService.saveNotifications(new Notifications(user.getUserName() + " is requested you to follow!!!", user1));
            } else if (user.getAccountType().equals("private") && user1.getAccountType().equals("public")) {
                connectiondetails.setStatus(new Status(1L));
                notificationService.saveNotifications(new Notifications(user.getUserName() + " is following you!!!", user1));
            }
            return new ResponseEntity<>(connectionRepoService.saveFollowRequest(connectiondetails), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Already Friends", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> isFollower(Long sender, Long receiver) {
        Optional<Connectiondetails> connectiondetails = connectionRepoService.findBySenderandReceiver(sender, receiver);
        if (connectiondetails.isPresent())
            return new ResponseEntity<>(connectiondetails.get(), HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @Override
    public List<Connectiondetails> getFollowers(Long userId) {
        return connectionRepoService.getAllFollowers(userId);
    }

    @Override
    public Long getFollowersCount(Long userId) {
        return connectionRepoService.getFrCount(userId);
    }

    @Override
    public Long getFollowingCount(Long userId) {
        return connectionRepoService.getFgCount(userId);

    }

    @Override
    public List<Connectiondetails> findFriends(Long userId) {
        return connectionRepoService.findFriendsList(userId);
    }

    @Override
    public ResponseEntity<?> removeFollow(ConnectionDTO connectionDTO) {
        Connectiondetails connectiondetails = connectionRepoService.findBySenderandReceiver(connectionDTO.getSender().getUserId(), connectionDTO.getReceiver().getUserId()).orElseThrow(() -> new NoSuchElementException("Connection is not Present"));

        if (connectiondetails != null) {
            connectiondetails.setStatus(new Status(1L));
            connectionRepoService.saveFollowRequest(connectiondetails);
        }
        return new ResponseEntity<>(connectionRepoService.removeFollowRequest(connectionDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> acceptRequest(ConnectionDTO connectionDTO) {
        Connectiondetails connectiondetails = connectionRepoService.findBySenderandReceiver(connectionDTO.getReceiver().getUserId(), connectionDTO.getSender().getUserId()).orElseThrow(() -> new NoSuchElementException("Connection is not Present"));
        connectiondetails.setStatus(new Status(1L));
        return new ResponseEntity<>(connectionRepoService.saveFollowRequest(connectiondetails), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> rejectRequest(ConnectionDTO connectionDTO) {
        return new ResponseEntity<>(connectionRepoService.removeFollowRequest(new ConnectionDTO(connectionDTO.getReceiver(), connectionDTO.getSender())), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getRequests(Long userId) {
        return new ResponseEntity<>(connectionRepoService.getRequestConnection(userId), HttpStatus.OK);
    }
}
