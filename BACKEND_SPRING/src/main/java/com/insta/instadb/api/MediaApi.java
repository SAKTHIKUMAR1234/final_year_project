package com.insta.instadb.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RequestMapping("/api/v1/media")
public interface MediaApi {

    @PostMapping("/addMedia")
    ResponseEntity<?> addNewMedia(@RequestParam("file") MultipartFile file, @RequestParam Long userId, @RequestParam List<String> interests,
                                  @RequestParam String description, @RequestParam String scheduledTime) throws IOException, ParseException;

    //    @DeleteMapping
//    ResponseEntity<?> reomoveMedia()
    @GetMapping("/getAllMedia/{userId}")
    ResponseEntity<?> getMediaByUser(@PathVariable Long userId) throws IOException;

    @GetMapping("/getMediaCount/{userId}")
    ResponseEntity<?> getMediaCount(@PathVariable Long userId);

    @GetMapping("/addInterest/{interests}")
    ResponseEntity<?> addInterest(@PathVariable String interests);

    @GetMapping("interest/isInterestExist")
    ResponseEntity<?> getIsInterestExist();

}
