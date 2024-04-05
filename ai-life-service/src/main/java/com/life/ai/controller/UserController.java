package com.life.ai.controller;

import com.ai_life.dto.UserLoginDTO;
import com.ai_life.entity.User;
import com.ai_life.vo.UserLoginVO;
import com.life.ai.properties.JwtProperties;
import com.life.ai.result.Result;
import com.life.ai.service.impl.UserServiceImpl;
import com.life.ai.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    JwtProperties jwtProperties;
    @PostMapping("/login")
    public Result login(@RequestBody UserLoginDTO userLoginDTO){
        User user =  userService.wxLogin(userLoginDTO);
        Long id =  user.getId();
        String openid = user.getOpenid();
        Map<String,Object> claims = new HashMap<>();
        claims.put("userid",id);
        String token = JwtUtil.createJWT(jwtProperties.getUserSecretKey(),jwtProperties.getUserTtl(),claims);
       UserLoginVO userLoginVo= UserLoginVO.builder().id(id).openId(openid).token(token).build();
        return Result.success(userLoginVo);
     }
}
