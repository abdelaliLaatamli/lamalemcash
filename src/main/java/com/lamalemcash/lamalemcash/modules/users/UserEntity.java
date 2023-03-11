package com.lamalemcash.lamalemcash.modules.users;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = -3745116046874542212L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_uuid",nullable = false)
    private String userUuid;

    @Column(name = "firstname",length = 50,nullable = false)
    private String firstname;

    @Column(name = "lastname", length = 50, nullable = false)
    private String lastname;

    @Column(nullable = false ,length = 120, unique = true)
    private String email;

    @Column(nullable = false)
    private String password ;


    // private String account_type;

    @Column(nullable = true)
    private String phone_number;

    @Column(nullable = true)
    private String emailVerificationToken;
    @Column(columnDefinition = "boolean default false" , nullable = false)
    private Boolean emailVerificationStatus=false;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
