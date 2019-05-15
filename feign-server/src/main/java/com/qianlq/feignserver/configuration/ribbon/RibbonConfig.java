package com.qianlq.feignserver.configuration.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author qianliqing
 * @date 2019/1/17 12:19 PM
 * email: qianlq0824@gmail.com
 */

@Configuration
public class RibbonConfig {

    @Bean
    @LoadBalanced
    public RestTemplate geRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule rule() {
        return new RandomRule();
    }
}
