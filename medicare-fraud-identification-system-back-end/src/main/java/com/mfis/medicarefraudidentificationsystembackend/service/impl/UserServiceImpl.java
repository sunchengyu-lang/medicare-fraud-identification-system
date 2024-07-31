package com.mfis.medicarefraudidentificationsystembackend.service.impl;

import com.mfis.medicarefraudidentificationsystembackend.mapper.UserMapper;
import com.mfis.medicarefraudidentificationsystembackend.pojo.User;
import com.mfis.medicarefraudidentificationsystembackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public void register(String username, String password) {
        String UtilsPwd = password;
        userMapper.add(username,UtilsPwd);
    }

    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }
}
