package com.life.ai.service.impl;

import com.ai_life.dto.UserLoginDTO;
import com.ai_life.entity.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.life.ai.mapper.UserMapper;
import com.life.ai.properties.WeChatProperties;
import com.life.ai.service.UserService;
import com.life.ai.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    public static final String WX_LOGIN = "https://api.wexin.qq.com/sns/jscode2session";
    @Autowired
    WeChatProperties weChatProperties;
    @Autowired
    UserMapper userMapper;
    @Override
    public User wxLogin(UserLoginDTO userLoginDTO) {
        String openid = getOpenid(userLoginDTO);
        if(openid == null){
            throw new RuntimeException("登入失败");
        }
       User user = userMapper.selectByID(openid);
       if(user == null){
           user = User.builder().openid(openid).createTime(LocalDateTime.now()).build();
           userMapper.insert(user);
       }
       return user;
    }

    private String getOpenid(UserLoginDTO userLoginDTO){
        Map<String,String> map = new HashMap<>();
        map.put("appid",weChatProperties.getAppid());
        map.put("secret",weChatProperties.getSecret());
        map.put("js_code", userLoginDTO.getCode());
        map.put("grant_type","authorization_code");
        String json = HttpClientUtil.doGet(WX_LOGIN,map);
        JSONObject jsonObject = JSON.parseObject(json);
        String openid = jsonObject.getString("openid");
        return openid;
    }
}
