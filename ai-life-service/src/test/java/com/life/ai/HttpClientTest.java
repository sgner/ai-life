package com.life.ai;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.LocalDateTime;

public class HttpClientTest {
    //GET请求
    @Test
    public void test() throws IOException {
     CloseableHttpClient httpClient = HttpClients.createDefault();
      HttpGet httpGet = new HttpGet("http://localhost:8080/depts");
      CloseableHttpResponse closeableHttpResponse =  httpClient.execute(httpGet);
        System.out.println(closeableHttpResponse.getStatusLine().getStatusCode());
        HttpEntity httpEntity = closeableHttpResponse.getEntity();
        System.out.println(EntityUtils.toString(httpEntity));
        closeableHttpResponse.close();
        httpClient.close();

        // post请求
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8080/");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",2);
        jsonObject.put("name","教研部");
        LocalDateTime localDateTime = LocalDateTime.now();
        jsonObject.put("createTime",localDateTime);
        jsonObject.put("updateTime",localDateTime);
        StringEntity entity = new StringEntity(jsonObject.toString());
        entity.setContentEncoding("utf-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
        CloseableHttpResponse closeableHttpResponse1= client.execute(httpPost);
        HttpEntity httpEntity1 = closeableHttpResponse1.getEntity();
        closeableHttpResponse1.close();
        client.close();


    }
}
