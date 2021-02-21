package com.nunezeric.randomfact.randomFact.randomfact.controller;

import com.nunezeric.randomfact.randomFact.randomfact.exception.ApiRequestException;
import com.nunezeric.randomfact.randomFact.randomfact.exception.CategoryNotFoundException;
import com.nunezeric.randomfact.randomFact.randomfact.model.Category;
import com.nunezeric.randomfact.randomFact.randomfact.model.RandomFact;
import com.nunezeric.randomfact.randomFact.randomfact.service.RandomFactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomFactController {

    private RandomFactService randomFactService;

    @Autowired
    public RandomFactController(RandomFactService randomFactService) {
        this.randomFactService = randomFactService;
    }

    @GetMapping("random/{category}")
    public RandomFact getRandomTypeFact(@PathVariable("category") String category) {
        boolean isCategory = isCategoryEnumPresent(category);

        if(!isCategory) {
            throw new CategoryNotFoundException(category + " was not found!");
        }
        RandomFact fact = randomFactService.getRandomFactByCategory(category);
        if(fact == null) {
            throw new ApiRequestException("There was a problem with your request!");
        }
        return fact;
    }

    private boolean isCategoryEnumPresent(String category) {
        Category[] arr = Category.values();
        try{
            for(Category c : arr) {
                if( Category.valueOf(category) == c) {
                    return true;
                }
            }
        }catch (IllegalArgumentException e) {
            return false;
        }
        return false;
    }
}
