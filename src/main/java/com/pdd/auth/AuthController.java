package com.pdd.auth;

import com.jayway.jsonpath.JsonPath;
import com.pdd.model.User;
import com.pdd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AuthController {

    @Autowired
    UserService userService;

    @GetMapping("/callback")
    private void auth(String code) throws IOException {
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+AuthUtil.APPID
                +"&secret="+AuthUtil.APPSECRET
                +"&code="+code
                +"&grant_type=authorization_code";
        String json = AuthUtil.doGetJson(url);
        String token = JsonPath.read(json, "$.access_token");
        String opendid = JsonPath.read(json, "$.openid");
        url = "https://api.weixin.qq.com/sns/userinfo?access_token="+token
                + "&openid="+opendid
                + "&lang=zh_CN";
        json = AuthUtil.doGetJson(url);
        String nickname = JsonPath.read(json, "$.nickname");
        Integer sex = JsonPath.read(json, "$.sex");
        String address = JsonPath.read(json, "$.country") + " "
                            + JsonPath.read(json, "$.province") + " "
                            + JsonPath.read(json, "$.city");
        User user = new User();
        user.setOpenid(opendid);
        user.setSex(sex);
        user.setNickname(nickname);
        user.setAddress(address);
        userService.addUser(user);
    }
}
