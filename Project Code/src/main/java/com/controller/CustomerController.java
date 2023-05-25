package com.controller;


import com.model.Customer;
import com.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
//import com.twilio.Twilio;
//import com.twilio.rest.api.v2010.account.Message;
//import com.twilio.type.PhoneNumber;
//import javax.persistence.Id;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;


    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @GetMapping(produces = {"application/json"})
    public List<Customer> getCustomer(){
        List<Customer> customer = customerService.getCustomer();
        logger.info("Customer list {} ",customer);
        return customer;
    }
//    public void sendsms(){
//        String ACCOUNT_SID = "AC237e9999ad28a8789527e45795b2bdea";
//        String AUTH_TOKEN = "ad4b23f18f86f07b9d36b67386e6ebd3";
//        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//        Message message = Message.creator(
//                        new com.twilio.type.PhoneNumber("+916301793703"),
//                        new com.twilio.type.PhoneNumber("+14406933183"),
//                        "Thank You for Dinning with us! Help us to improve by providing your valuable feedback below")
//                .create();
//        System.out.println(message.getSid());
//    }
    @PostMapping("/create")
    public Customer createCustomer(@RequestBody Customer customer){
        logger.info("create customer is invoked {}",customer);
//        sendsms();
        return customerService.createCustomer(customer);
    }

    @GetMapping(value = "/{id}",produces = {"application/json"})
    public Customer getCustomerById(@PathVariable("id") int id){
        logger.info("getMenuById is invoked with menu Id :{}",id);
        return customerService.getCustomerById(id);
    }

    @PutMapping("/update")
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public Customer deleteCustomerById(@PathVariable("id") int id){
        return customerService.deleteCustomerById((id));
    }
}
