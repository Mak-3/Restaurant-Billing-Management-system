package com.services;

import com.model.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> getPayment();

    Payment createPayment(Payment payment);
    Payment getPaymentById(int id);

    Payment updatePayment(Payment payment);

    Payment deletePaymentById(int id);
}
