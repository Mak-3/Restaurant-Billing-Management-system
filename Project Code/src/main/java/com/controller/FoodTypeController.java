package com.controller;


import com.model.FoodType;
import com.services.FoodTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/foodType")

public class FoodTypeController {

    @Autowired
    FoodTypeService foodTypeService;


    private static final Logger logger = LoggerFactory.getLogger(FoodTypeController.class);

    @GetMapping
    public List<FoodType> getFoodType(){
        logger.info("FoodType list");
        return foodTypeService.getFoodType();
    }
    @PostMapping("/create")
    public FoodType createFoodType(@RequestBody FoodType foodType){
        logger.info("create foodType is invoked {}",foodType);
        return foodTypeService.createFoodType(foodType);
    }

    @GetMapping("/{id}")
    public FoodType getFoodTypeById(@PathVariable("id") int id){
        logger.info("getMenuById is invoked with menu Id :{}",id);
        return foodTypeService.getFoodTypeById(id);
    }

    @PutMapping("/update")
    public FoodType updateFoodType(@RequestBody FoodType foodType){
        return foodTypeService.updateFoodType(foodType);
    }

    @DeleteMapping("/{id}")
    public FoodType deleteFoodTypeById(@PathVariable("id") int id){
        return foodTypeService.deleteFoodTypeById((id));
    }
}
