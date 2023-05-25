package com.controller;


import com.model.Payment;
import com.services.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/payment")

public class PaymentController {

    @Autowired
    PaymentService paymentService;


    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @GetMapping
    public List<Payment> getPayment(){
        logger.info("Payment list");
        return paymentService.getPayment();
    }
    @PostMapping("/create")
    public Payment createPayment(@RequestBody Payment payment){
        logger.info("create payment is invoked {}",payment);
        return paymentService.createPayment(payment);
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable("id") int id){
        logger.info("getMenuById is invoked with menu Id :{}",id);
        return paymentService.getPaymentById(id);
    }

    @PutMapping("/update")
    public Payment updatePayment(@RequestBody Payment payment){
        return paymentService.updatePayment(payment);
    }

    @DeleteMapping("/{id}")
    public Payment deletePaymentById(@PathVariable("id") int id){
        return paymentService.deletePaymentById((id));
    }
}
