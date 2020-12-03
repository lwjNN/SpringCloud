package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymenFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lwj
 * @date 2020/8/29 16:33
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    PaymenFeignService paymenFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymenFeignService.getPaymentBiId(id);
    }
    @GetMapping("/consumer/payment/feign/timeout")
    public String timeout() {
        return paymenFeignService.timeout();
    }
}
