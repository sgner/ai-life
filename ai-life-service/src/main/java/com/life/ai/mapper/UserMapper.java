package com.life.ai.mapper;

import com.ai_life.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where openid = #{openid}")
    public User selectByID(String openid);
    public void insert(User user);
}
