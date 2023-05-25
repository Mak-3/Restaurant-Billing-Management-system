package com.controller;


import com.model.AvgRating;
import com.services.AvgRatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/avgRating")

public class AvgRatingController {

    @Autowired
    AvgRatingService avgRatingService;


    private static final Logger logger = LoggerFactory.getLogger(AvgRatingController.class);

    @GetMapping
    public List<AvgRating> getAvgRating(){
        logger.info("AvgRating list");
        return avgRatingService.getAvgRating();
    }
    @PostMapping("/create")
    public AvgRating createAvgRating(@RequestBody AvgRating avgRating){
        logger.info("create avgRating is invoked {}",avgRating);
        return avgRatingService.createAvgRating(avgRating);
    }

    @GetMapping("/{id}")
    public AvgRating getAvgRatingById(@PathVariable("id") int id){
        logger.info("getMenuById is invoked with menu Id :{}",id);
        return avgRatingService.getAvgRatingById(id);
    }

    @PutMapping("/update")
    public AvgRating updateAvgRating(@RequestBody AvgRating avgRating){
        return avgRatingService.updateAvgRating(avgRating);
    }

    @DeleteMapping("/{id}")
    public AvgRating deleteAvgRatingById(@PathVariable("id") int id){
        return avgRatingService.deleteAvgRatingById((id));
    }
}
