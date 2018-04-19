package com.pdd.mapper;

import com.pdd.model.User;

public interface UserMapper {

    int insert(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

}