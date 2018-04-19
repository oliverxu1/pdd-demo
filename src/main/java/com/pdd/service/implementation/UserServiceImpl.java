package com.pdd.service.implementation;

import com.pdd.mapper.UserMapper;
import com.pdd.model.User;
import com.pdd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(int uid) {
        return userMapper.selectByPrimaryKey(uid);
    }

    @Transactional
    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }
}
