package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author lwj
 * @date 2020/8/18 12:30
 */
public interface LoadBalancer {

    ServiceInstance getInstance(List<ServiceInstance> list);
}
