package org.cloud.springcloud.controller;

import org.cloud.springcloud.entity.CommonResult;
import org.cloud.springcloud.entity.Payment;
import org.cloud.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        Integer result = paymentService.create(payment);
        log.info("insert: " + result);
        if (result > 0) {
            return new CommonResult(200, "insert success", result);
        } else {
            return new CommonResult(404, "insert fail", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("payment: " + payment);
        if (payment != null) {
            return new CommonResult(200, "query success", payment);
        } else {
            return new CommonResult(404, "query fail", null);
        }
    }
}