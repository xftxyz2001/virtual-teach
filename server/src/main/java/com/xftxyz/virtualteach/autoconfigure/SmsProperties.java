package com.xftxyz.virtualteach.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "aliyun.sms")
public class SmsProperties {

    private String endpoint;

    private String accessKeyId;

    private String accessKeySecret;

    private String region;

    private String signName;

    private String code;
}
