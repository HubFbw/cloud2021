package com.fu.springcloud.controller;

import com.fu.springcloud.bean.CommonResult;
import com.fu.springcloud.bean.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.fu.springcloud.service.PaymentService;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPost;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result);
        if (result > 0){
            return new CommonResult(200,"插入数据库成功,serverPost:"+serverPost,result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable(value = "id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果：" + payment);
        if (payment != null){
            return new CommonResult(200,"数据查询成功,serverPost:"+serverPost,payment);
        }else {
            return new CommonResult(444,"没有对应id",null);
        }
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPost;
    }
}
