package com.yflash.tech.SampleAPI.service;

import com.yflash.tech.SampleAPI.entity.UserEntity;
import com.yflash.tech.SampleAPI.model.out.User;

import java.util.List;

public interface UserService {

    List<UserEntity> getAllUsers();
    User getUserById(Integer id);

}
