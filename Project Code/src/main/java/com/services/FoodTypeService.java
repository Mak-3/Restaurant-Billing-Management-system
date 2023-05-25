package com.services;

import com.model.FoodType;

import java.util.List;

public interface FoodTypeService {
    List<FoodType> getFoodType();

    FoodType createFoodType(FoodType foodType);
    FoodType getFoodTypeById(int id);

    FoodType updateFoodType(FoodType foodType);

    FoodType deleteFoodTypeById(int id);
}
