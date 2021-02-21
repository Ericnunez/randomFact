package com.nunezeric.randomfact.randomFact.randomfact.service;

import com.nunezeric.randomfact.randomFact.randomfact.model.Category;
import com.nunezeric.randomfact.randomFact.randomfact.repository.RandomFactRepository;
import com.nunezeric.randomfact.randomFact.randomfact.model.RandomFact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RandomFactService {

    private RandomFactRepository randomFactRepository;

    @Autowired
    public RandomFactService(RandomFactRepository randomFactRepository) {
        this.randomFactRepository = randomFactRepository;
    }

    public RandomFact getRandomFact() {
        Long count = randomFactRepository.count();
        int idx = (int)(Math.random() * count) + 1;
        return randomFactRepository.findById(idx).orElse(null);
    }

    public RandomFact getRandomFactByCategory(String category) {
        return randomFactRepository.findByCategory(category);

    }
}
