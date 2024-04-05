package com.life.ai.service;

import com.ai_life.dto.UserLoginDTO;
import com.ai_life.entity.User;

public interface UserService {
      public User wxLogin(UserLoginDTO userLoginDTO);
}
