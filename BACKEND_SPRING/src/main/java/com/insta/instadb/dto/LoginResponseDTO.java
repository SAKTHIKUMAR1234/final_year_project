package com.insta.instadb.dto;

import lombok.Data;

@Data
public class LoginResponseDTO {

    private String accessToken;

    private Long userId;
}
