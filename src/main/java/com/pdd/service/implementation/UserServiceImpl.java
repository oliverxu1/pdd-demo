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
        if (user.getOpenid() != null && !"".equals(user.getOpenid())) {
            try {
                int effectedNum = userMapper.insert(user);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("添加新用户失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加新用户失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("新用户openId不能为空！");
        }
    }

    @Override
    public boolean updateUser(User user) {
        if (user.getUid() != null && user.getUid() > 0) {
            try {
                int effectedNum = userMapper.updateByPrimaryKeySelective(user);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新用户信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新用户信息失败: " + e.getMessage());
            }
        } else {
            throw new RuntimeException("无法找到该用户！");
        }
    }
}
