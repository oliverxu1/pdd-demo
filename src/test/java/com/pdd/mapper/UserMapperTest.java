package com.pdd.mapper;

import com.pdd.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setOpenid("8888");
        user.setNickname("shidizai");
        user.setSex(0);
        user.setAddress("Wuxi");
        user.setPhonenum("18600008888");
        int effectedNum = userMapper.insert(user);
        assertEquals(1, effectedNum);
    }

    @Test
    public void selectByPrimaryKey() {
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user.getUid());
        System.out.println(user.getOpenid());
        System.out.println(user.getNickname());
        System.out.println(user.getAddress());
        System.out.println(user.getPhonenum());
        assertEquals("mai", user.getNickname());
    }

    @Test
    public void updateByPrimaryKeySelective() {
        User user = userMapper.selectByPrimaryKey(4);
        user.setNickname("niu");
        user.setAddress("CQ");
        user.setPhonenum("131210099");
        int effectedNum = userMapper.updateByPrimaryKeySelective(user);
        assertEquals(1, effectedNum);
    }
}