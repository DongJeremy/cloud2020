package org.cloud.springcloud.controller;

import org.cloud.springcloud.entity.CommonResult;
import org.cloud.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PaymentController {

    //public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        HttpEntity<Payment> requestEntity = new HttpEntity<>(payment, null);
        ResponseEntity<CommonResult<Payment>> responseEntity = restTemplate.exchange(PAYMENT_URL + "/payment/create",
                HttpMethod.POST, requestEntity, new ParameterizedTypeReference<CommonResult<Payment>>() {
                });
        log.info("get data from remote: " + responseEntity.getBody());
        return responseEntity.getBody();
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult<Payment>> responseEntity = restTemplate.exchange(PAYMENT_URL + "/payment/get/" + id,
                HttpMethod.GET, null, new ParameterizedTypeReference<CommonResult<Payment>>() {
                });
        log.info("get data from remote: " + responseEntity.getBody());
        return responseEntity.getBody();
    }
}
