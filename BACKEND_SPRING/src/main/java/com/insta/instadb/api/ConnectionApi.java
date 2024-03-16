package com.insta.instadb.api;

import com.insta.instadb.dto.ConnectionDTO;
import com.insta.instadb.entity.Connectiondetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/request")
public interface ConnectionApi {
    @PostMapping("/followRequest")
    ResponseEntity<?> followRequest(@RequestBody Connectiondetails connectiondetails);

    @PostMapping("/removeFollow")
    ResponseEntity<?> removeFollowRequest(@RequestBody ConnectionDTO connectionDTO);

    @PostMapping("/getRequestedConnections/{userId}")
    ResponseEntity<?> requestedList(@PathVariable Long userId);

    @PostMapping("/acceptedRequest")
    ResponseEntity<?> acceptedFollowRequest(@RequestBody ConnectionDTO connectionDTO);

    @PostMapping("/rejectRequest")
    ResponseEntity<?> rejectedFollowRequest(@RequestBody ConnectionDTO connectionDTO);

    @GetMapping("/getConnectionCount/{userId}")
    ResponseEntity<?> followersandfollwingCount(@PathVariable Long userId);
}
