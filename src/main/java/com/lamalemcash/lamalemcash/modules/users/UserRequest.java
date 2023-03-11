package com.lamalemcash.lamalemcash.modules.users;

import lombok.Data;

@Data
public class UserRequest {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phone_number;
}
