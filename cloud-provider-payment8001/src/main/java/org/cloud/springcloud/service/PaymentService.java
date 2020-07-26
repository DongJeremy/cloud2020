package org.cloud.springcloud.service;

import org.cloud.springcloud.entity.Payment;

public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(long id);
}
