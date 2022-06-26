package com.qf.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 * @version V1.0
 * @Project estest
 * @Package com.qf.config
 * @Description:
 * @Date 2022/6/20 19:31
 */
@Configuration
@ComponentScan("com.qf")
public class EsConfig {
    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }


    @Bean
    public RestHighLevelClient client(){
        RestClientBuilder restClientBuilder =RestClient.builder(new HttpHost("172.20.57.211",9200));
        restClientBuilder.setRequestConfigCallback(new RestClientBuilder.RequestConfigCallback() {
            @Override
            public RequestConfig.Builder customizeRequestConfig(RequestConfig.Builder builder) {
                builder.setConnectTimeout(10000);
                builder.setSocketTimeout(10000);
                builder.setConnectionRequestTimeout(10000);
                return builder;
            }
        });
        return new RestHighLevelClient(restClientBuilder);

    }
}
