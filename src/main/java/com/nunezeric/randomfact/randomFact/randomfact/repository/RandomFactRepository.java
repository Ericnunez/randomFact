package com.nunezeric.randomfact.randomFact.randomfact.repository;

import com.nunezeric.randomfact.randomFact.randomfact.model.Category;
import com.nunezeric.randomfact.randomFact.randomfact.model.RandomFact;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RandomFactRepository extends JpaRepository<RandomFact,Integer> {
    @Query(value="SELECT * FROM random_fact r\n" +
            "WHERE r.category = :category\n" +
            "ORDER BY RANDOM()\n" +
            "LIMIT 1", nativeQuery = true)
    RandomFact findByCategory(String category);

    
}
