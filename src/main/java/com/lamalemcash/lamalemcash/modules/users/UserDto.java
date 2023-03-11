package com.lamalemcash.lamalemcash.modules.users;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * this class is class user intermediary between layers
 * application layer and service layer and repository layer
 * this class used for loose coupling
 */
@Data
public class UserDto implements Serializable {


    private static final long serialVersionUID = 3459056878010144225L;
    private long id;

    private String userUuid;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phone_number;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String encryptedPassword;
    private String emailVerificationToken;
    private Boolean emailVerificationStatus = false;


}
