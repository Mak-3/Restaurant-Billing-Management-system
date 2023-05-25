package com.services;

import com.model.AvgRating;

import java.util.List;

public interface AvgRatingService {
    List<AvgRating> getAvgRating();

    AvgRating createAvgRating(AvgRating avgRating);
    AvgRating getAvgRatingById(int id);

    AvgRating updateAvgRating(AvgRating avgRating);

    AvgRating deleteAvgRatingById(int id);
}
