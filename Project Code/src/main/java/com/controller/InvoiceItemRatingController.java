package com.controller;


import com.model.InvoiceItemRating;
import com.services.InvoiceItemRatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/invoiceItemRating")

public class InvoiceItemRatingController {
    @Autowired
    InvoiceItemRatingService invoiceItemRatingService;


    private static final Logger logger = LoggerFactory.getLogger(InvoiceItemRatingController.class);

    @GetMapping
    public List<InvoiceItemRating> getInvoiceItemRating(){
        logger.info("InvoiceItemRating list");
        return invoiceItemRatingService.getInvoiceItemRating();
    }
    @PostMapping("/create")
    public InvoiceItemRating createInvoiceItemRating(@RequestBody InvoiceItemRating invoiceItemRating){
        logger.info("create invoiceItemRating is invoked {}",invoiceItemRating);
        return invoiceItemRatingService.createInvoiceItemRating(invoiceItemRating);
    }

    @GetMapping("/{id}")
    public InvoiceItemRating getInvoiceItemRatingById(@PathVariable("id") int id){
        logger.info("getMenuById is invoked with menu Id :{}",id);
        return invoiceItemRatingService.getInvoiceItemRatingById(id);
    }

    @PutMapping("/update")
    public InvoiceItemRating updateInvoiceItemRating(@RequestBody InvoiceItemRating invoiceItemRating){
        return invoiceItemRatingService.updateInvoiceItemRating(invoiceItemRating);
    }

    @DeleteMapping("/{id}")
    public InvoiceItemRating deleteInvoiceItemRatingById(@PathVariable("id") int id){
        return invoiceItemRatingService.deleteInvoiceItemRatingById((id));
    }
}
