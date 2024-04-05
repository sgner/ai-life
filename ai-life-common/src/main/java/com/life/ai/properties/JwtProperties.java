package com.life.ai.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "life.ai.jwt")
@Data
@Component
public class JwtProperties {
      private String adminSecretKey;
      private Long adminTtl;
      private String adminTokenName;
      private String userSecretKey;
      private Long userTtl;
      private String userTokenName;
}
