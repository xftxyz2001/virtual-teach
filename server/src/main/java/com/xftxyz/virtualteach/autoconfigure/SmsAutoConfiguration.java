package com.xftxyz.virtualteach.autoconfigure;

import com.aliyun.auth.credentials.Credential;
import com.aliyun.auth.credentials.provider.StaticCredentialProvider;
import com.aliyun.sdk.service.dysmsapi20170525.AsyncClient;
import darabonba.core.client.ClientOverrideConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SmsProperties.class)
public class SmsAutoConfiguration {
    @Bean
    @ConditionalOnProperty(prefix = "aliyun.sms", value = "endpoint")
    public StaticCredentialProvider staticCredentialProvider(SmsProperties smsProperties) {
        return StaticCredentialProvider.create(Credential.builder()
                .accessKeyId(smsProperties.getAccessKeyId())
                .accessKeySecret(smsProperties.getAccessKeySecret())
                .build());
    }

    @Bean
    @ConditionalOnBean(StaticCredentialProvider.class)
    public AsyncClient asyncClient(StaticCredentialProvider staticCredentialProvider, SmsProperties smsProperties) {
        return AsyncClient.builder().region(smsProperties.getRegion())
                .credentialsProvider(staticCredentialProvider)
                .overrideConfiguration(ClientOverrideConfiguration.create()
                        .setEndpointOverride(smsProperties.getEndpoint()))
                .build();
    }
}
