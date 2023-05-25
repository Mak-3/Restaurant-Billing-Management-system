package com.controller;


import com.model.InvoiceItem;
import com.services.InvoiceItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/invoiceItem")

public class InvoiceItemController {
    @Autowired
    InvoiceItemService invoiceItemService;


    private static final Logger logger = LoggerFactory.getLogger(InvoiceItemController.class);

    @GetMapping
    public List<InvoiceItem> getInvoiceItem(){
        logger.info("InvoiceItem list");
        return invoiceItemService.getInvoiceItem();
    }
    @PostMapping("/create")
    public InvoiceItem createInvoiceItem(@RequestBody InvoiceItem invoiceItem){
        logger.info("create invoiceItem is invoked {}",invoiceItem);
        return invoiceItemService.createInvoiceItem(invoiceItem);
    }

    @GetMapping("/{id}")
    public InvoiceItem getInvoiceItemById(@PathVariable("id") int id){
        logger.info("getMenuById is invoked with menu Id :{}",id);
        return invoiceItemService.getInvoiceItemById(id);
    }

    @PutMapping("/update")
    public InvoiceItem updateInvoiceItem(@RequestBody InvoiceItem invoiceItem){
        return invoiceItemService.updateInvoiceItem(invoiceItem);
    }

    @DeleteMapping("/{id}")
    public InvoiceItem deleteInvoiceItemById(@PathVariable("id") int id){
        return invoiceItemService.deleteInvoiceItemById((id));
    }
}
