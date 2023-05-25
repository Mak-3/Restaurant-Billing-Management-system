package com.controller;


import com.model.Taxes;
import com.services.TaxesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/taxes")

public class TaxesController {

    @Autowired
    TaxesService taxesService;


    private static final Logger logger = LoggerFactory.getLogger(TaxesController.class);

    @GetMapping
    public List<Taxes> getTaxes(){
        logger.info("Taxes list");
        return taxesService.getTaxes();
    }
    @PostMapping("/create")
    public Taxes createTaxes(@RequestBody Taxes taxes){
        logger.info("create taxes is invoked {}",taxes);
        return taxesService.createTaxes(taxes);
    }

    @GetMapping("/{id}")
    public Taxes getTaxesById(@PathVariable("id") int id){
        logger.info("getMenuById is invoked with menu Id :{}",id);
        return taxesService.getTaxesById(id);
    }

    @PutMapping("/update")
    public Taxes updateTaxes(@RequestBody Taxes taxes){
        return taxesService.updateTaxes(taxes);
    }

    @DeleteMapping("/{id}")
    public Taxes deleteTaxesById(@PathVariable("id") int id){
        return taxesService.deleteTaxesById((id));
    }
}
