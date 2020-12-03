package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 手写轮询负载均衡
 * @author lwj
 * @date 2020/8/18 12:31
 */
@Component
public class MyLb implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!atomicInteger.compareAndSet(current, next));
        System.out.println("****第几次访问next:" + next);
        return next;
    }


    @Override
    public ServiceInstance getInstance(List<ServiceInstance> list) {
        int index = getAndIncrement() % list.size();
        return list.get(index);
    }
}
