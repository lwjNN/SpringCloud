package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHistrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author lwj
 * @date 2020/9/14 19:25
 */
@RestController
public class OrderHystrixController {

    @Resource
    private PaymentHistrixService paymentHistrixService;

    @GetMapping("/consumer/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentHistrixService.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public String paymentInfo_TIMEOUT(Integer id) {
        String result = paymentHistrixService.paymentInfo_TIMEOUT(id);
        return result;
    }

    public String paymentInfoTimeOutFallbackMethod(Integer id){
        return "我是消费者80，对方支付系统繁忙，请稍后重试或者自己运行出错。。。o(╥﹏╥)o";
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "我是消费者80，对方支付系统繁忙，请稍后重试。。。o(╥﹏╥)o";
    }

    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后重试";
    }
}
