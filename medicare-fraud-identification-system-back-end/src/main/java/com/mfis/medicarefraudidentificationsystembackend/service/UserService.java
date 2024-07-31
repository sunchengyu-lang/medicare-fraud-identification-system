package com.mfis.medicarefraudidentificationsystembackend.service;

import com.mfis.medicarefraudidentificationsystembackend.pojo.User;
import org.springframework.stereotype.Service;


public interface UserService {
    User findByUserName(String username);

    void register(String username, String password);

    void update(User user);
}
