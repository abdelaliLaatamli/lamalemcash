package com.lamalemcash.lamalemcash.modules.users;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponse {

    private String userUuid;
    private String firstname;
    private String lastname;
    private String email;
    private String phone_number;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
