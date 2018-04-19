package com.pdd.service.implementation;

import com.pdd.model.User;
import com.pdd.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    public void getUserById() {
        User user = userService.getUserById(5);
        System.out.println(user.getUid());
        System.out.println(user.getOpenid());
        System.out.println(user.getNickname());
        System.out.println(user.getAddress());
        System.out.println(user.getPhonenum());
        assertEquals("shidizai", user.getNickname());
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setOpenid("88912");
        user.setNickname("pdd");
        user.setSex(0);
        boolean effectedNum = userService.addUser(user);
        assertEquals(true, effectedNum);
    }

    @Test
    public void updateUser() {
        User user = userService.getUserById(7);
        user.setPhonenum("133312837");
        user.setSex(1);
        user.setOpenid("98789");
        boolean effectedNum = userService.updateUser(user);
        assertEquals(true, effectedNum);
    }
}