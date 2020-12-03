package com.atguigu.springcloud.service;

import com.atguigu.springcloud.service.impl.PaymentFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lwj
 * @date 2020/9/14 19:22
 */
@Service
@FeignClient(value="CLOUD-PROVIDER-HYSTRIX-PAYMENT"/*, fallback = PaymentFallbackServiceImpl.class*/)
public interface PaymentHistrixService {

    @GetMapping("payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("payment/hystrix/timeout/{id}")
    public String paymentInfo_TIMEOUT(@PathVariable("id") Integer id);
}
