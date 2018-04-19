package com.pdd.auth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class CallBackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        System.out.println(code);
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+AuthUtil.APPID
                + "&secret="+AuthUtil.APPSECRET
                + "&code="+code
                + "&grant_type=authorization_code";
        AuthUtil.doGetJson(url);
    }
}
