package com.insta.instadb.dto;

import com.insta.instadb.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConnectionDTO {

    private User sender;

    private User receiver;
}
