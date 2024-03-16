package com.insta.instadb.repository;

import com.insta.instadb.entity.Connectiondetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConnectionRepo extends JpaRepository<Connectiondetails, Long> {
    Connectiondetails findBySender_UserIdAndReceiver_UserId(Long sender, Long receiver);

    Long countConnectiondetailsByReceiver_UserIdAndStatus_IdNot(Long receiver_userId, Long status_id);

    Long countConnectiondetailsBySender_UserIdAndStatus_IdNot(Long userId, Long status);

    List<Connectiondetails> findConnectiondetailsBySender_UserIdAndStatus_Id(Long userId, Long statusId);

    List<Connectiondetails> findConnectiondetailsByReceiver_UserIdAndStatus_Id(Long userId, Long status);

    void deleteConnectiondetailsBySenderUserIdAndReceiverUserId(Long user1, Long user2);
}
