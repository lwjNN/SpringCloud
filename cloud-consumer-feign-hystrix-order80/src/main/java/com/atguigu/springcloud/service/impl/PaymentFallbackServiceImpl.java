package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentHistrixService;
import org.springframework.stereotype.Service;

/**
 * @author lwj
 * @date 2020/9/15 15:59
 */
@Service
public class PaymentFallbackServiceImpl implements PaymentHistrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----------PaymentFallbackService fall back-paymentInfo_OK,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TIMEOUT(Integer id) {
        return "-----------PaymentFallbackService fall back-paymentInfo_TIMEOUT,o(╥﹏╥)o";
    }
}
