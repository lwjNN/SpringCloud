package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lwj
 * @date 2020/8/12 16:24
 */
@Configuration
public class MySelfRule {

    /**
     * 自定义负载均衡策略为随机访问(默认为轮询)
     * @return
     */
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
