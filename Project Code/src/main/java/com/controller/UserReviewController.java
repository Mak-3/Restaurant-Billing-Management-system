package com.controller;


import com.model.UserReview;
import com.services.UserReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/userReview")

public class UserReviewController {
    @Autowired
    UserReviewService userReviewService;


    private static final Logger logger = LoggerFactory.getLogger(UserReviewController.class);

    @GetMapping
    public List<UserReview> getUserReview(){
        logger.info("UserReview list");
        return userReviewService.getUserReview();
    }
    @PostMapping("/create")
    public UserReview createUserReview(@RequestBody UserReview userReview){
        logger.info("create userReview is invoked {}",userReview);
        return userReviewService.createUserReview(userReview);
    }

    @GetMapping("/{id}")
    public UserReview getUserReviewById(@PathVariable("id") int id){
        logger.info("getMenuById is invoked with menu Id :{}",id);
        return userReviewService.getUserReviewById(id);
    }

    @PutMapping("/update")
    public UserReview updateUserReview(@RequestBody UserReview userReview){
        return userReviewService.updateUserReview(userReview);
    }

    @DeleteMapping("/{id}")
    public UserReview deleteUserReviewById(@PathVariable("id") int id){
        return userReviewService.deleteUserReviewById((id));
    }
}
