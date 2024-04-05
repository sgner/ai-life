package com.life.ai.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "aliyun.oss")
@Component
@Data
public class AliOssProperties {
    private String endpoint;
    private String  OSS_ACCESS_KEY_ID;
    private String OSS_ACCESS_KEY_SECRET;
    private String bucketName;
}
