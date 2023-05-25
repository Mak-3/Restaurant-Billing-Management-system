package com.controller;

import com.model.Invoice;
import com.services.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/invoice")
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;

    private static final Logger logger = LoggerFactory.getLogger(InvoiceController.class);

    @GetMapping
    public List<Invoice> getInvoice(){
        logger.info("Invoice list");
        return invoiceService.getInvoice();
    }
    @PostMapping("/create")
    public Invoice createInvoice(@RequestBody Invoice invoice){
        logger.info("create invoice is invoked {}",invoice);
        return invoiceService.createInvoice(invoice);
    }

    @GetMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable("id") int id){
        logger.info("getInvoiceById is invoked with menu Id :{}",id);
        return invoiceService.getInvoiceById(id);
    }

    @PutMapping("/update")
    public Invoice updateInvoice(@RequestBody Invoice invoice){
        return invoiceService.updateInvoice(invoice);
    }

    @DeleteMapping("/{id}")
    public Invoice deleteInvoiceById(@PathVariable("id") int id){
        return invoiceService.deleteInvoiceById(id);
    }
}
