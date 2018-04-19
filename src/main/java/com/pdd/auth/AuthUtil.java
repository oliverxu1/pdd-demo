package com.pdd.auth;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class AuthUtil {

    public static final String APPID = "wxc0204d163a02b5b7";
    public static final String APPSECRET = "0bdb036995bf920eb86e185ce921eaa7";

    public static String doGetJson(String url) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            String result = EntityUtils.toString(entity, "UTF-8");
            return result;
        }
        httpGet.releaseConnection();
        return null;
    }
}
