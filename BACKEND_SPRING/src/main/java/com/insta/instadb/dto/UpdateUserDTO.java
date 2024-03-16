package com.insta.instadb.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UpdateUserDTO {

    private MultipartFile file;
    private UserDTO userDTO;
}
