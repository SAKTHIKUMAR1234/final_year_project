package com.insta.instadb.repository.service.Impl;

import com.insta.instadb.dto.ConnectionDTO;
import com.insta.instadb.entity.Connectiondetails;
import com.insta.instadb.repository.ConnectionRepo;
import com.insta.instadb.repository.service.ConnectionRepoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ConnectionRepoImpl implements ConnectionRepoService {

    @Autowired
    private ConnectionRepo connectionRepo;

    @Override
    public Connectiondetails saveFollowRequest(Connectiondetails connectiondetails) {
        return connectionRepo.save(connectiondetails);
    }

    @Override
    public Optional<Connectiondetails> findBySenderandReceiver(Long sender, Long receiver) {
        return Optional.ofNullable(connectionRepo.findBySender_UserIdAndReceiver_UserId(sender, receiver));
    }

    @Override
    public Long getFrCount(Long userId) {
        return connectionRepo.countConnectiondetailsByReceiver_UserIdAndStatus_IdNot(userId, 2L);
    }

    @Override
    public Long getFgCount(Long userId) {
        return connectionRepo.countConnectiondetailsBySender_UserIdAndStatus_IdNot(userId, 2L);
    }

    @Override
    public Connectiondetails changeStatus(ConnectionDTO connectionDTO) {
        return connectionRepo.findBySender_UserIdAndReceiver_UserId(connectionDTO.getReceiver().getUserId(), connectionDTO.getSender().getUserId());
    }

    @Override
    public List<Connectiondetails> findFriendsList(Long userId) {
        return connectionRepo.findConnectiondetailsBySender_UserIdAndStatus_Id(userId, 4L);
    }

    @Override
    public List<Connectiondetails> getAllFollowers(Long userId) {
        return connectionRepo.findConnectiondetailsBySender_UserIdAndStatus_Id(userId, 2L);
    }

    @Transactional
    @Override
    public String removeFollowRequest(ConnectionDTO connectionDTO) {
        System.out.println(connectionDTO);
        connectionRepo.deleteConnectiondetailsBySenderUserIdAndReceiverUserId(connectionDTO.getSender().getUserId(), connectionDTO.getReceiver().getUserId());
        return "Unfollowed Successfully!!!";
    }

    @Override
    public List<Connectiondetails> getRequestConnection(Long userId) {
        return connectionRepo.findConnectiondetailsByReceiver_UserIdAndStatus_Id(userId, 2L);
    }
}
