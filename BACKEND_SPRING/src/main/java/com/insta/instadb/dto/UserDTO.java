package com.insta.instadb.dto;

import lombok.Data;

@Data
public class UserDTO {

    private Long userId;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String phNo;
}
