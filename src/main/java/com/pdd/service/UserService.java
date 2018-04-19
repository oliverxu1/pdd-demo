package com.pdd.service;

import com.pdd.model.User;

public interface UserService {

    /**
     * 获取特定用户的信息
     *
     * @param uid
     * @return
     */
    User getUserById(int uid);

    /**
     * 添加新用户
     *
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 更新特定用户信息
     *
     * @param user
     * @return
     */
    boolean updateUser(User user);

}
