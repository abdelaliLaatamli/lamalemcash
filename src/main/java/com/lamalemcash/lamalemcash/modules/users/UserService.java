package com.lamalemcash.lamalemcash.modules.users;


import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;


    public UserDto createUser(UserDto userDto){

        userRepository.findByEmail(userDto.getEmail()).orElseThrow(() -> new RuntimeException("This user already exists !"));

       // UserEntity userEntity = new UserEntity();
       // BeanUtils.copyProperties( userDto , userEntity );

        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);


        // CryptPassword
        userEntity.setPassword( passwordEncoder.encode(userEntity.getPassword())  );
        userEntity.setUserUuid( UUID.randomUUID().toString() );

        UserEntity createdUserEntity = userRepository.save(userEntity);

        UserDto createdUserDto = new UserDto();
        BeanUtils.copyProperties(createdUserEntity , createdUserDto );

        return createdUserDto;
    }
}
