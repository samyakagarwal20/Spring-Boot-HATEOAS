package com.yflash.tech.SampleAPI.service.impl;

import com.yflash.tech.SampleAPI.entity.UserEntity;
import com.yflash.tech.SampleAPI.model.out.User;
import com.yflash.tech.SampleAPI.repository.UserRepository;
import com.yflash.tech.SampleAPI.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepository userRepository;

    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        UserEntity userEntity = userRepository.getReferenceById(id);
        return modelMapper.map(userEntity,User.class);
    }
}
