package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class PaymentController
{
    @Resource
    private PaymentService paymentService;

    @PostMapping(value="/payment/create")
    public CommonResult create(@RequestBody Payment payment) //对外提供服务
    {
        System.out.println("*******come in");
        paymentService.create(payment);
        return new CommonResult(200,"payment action success",payment);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> gePayment(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        System.out.println("根据id获取支付信息: "+payment);
        return new CommonResult<>(payment);
    }

    @GetMapping(value="/payment/info")
    public String info()
    {
        System.out.println("888888888测试8888888888888888");
        return "*****abc";
    }
}

