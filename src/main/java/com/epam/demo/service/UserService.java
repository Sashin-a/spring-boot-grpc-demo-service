package com.epam.demo.service;

import com.epam.demo.entity.UserEntity;
import com.epam.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;



    public UserEntity getUserById(int id) {
        return userRepository.findById(id).get();
//        return new UserEntity();
    }

    public UserEntity save(UserEntity userEntity)
    {
        return userRepository.save(userEntity);
//        return userEntity;
    }



}
