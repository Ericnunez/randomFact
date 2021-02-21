package com.nunezeric.randomfact.randomFact.trivia.repository;

import com.nunezeric.randomfact.randomFact.trivia.model.Trivia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Eric Nunez
 */
public interface TriviaRepository extends JpaRepository<Trivia, Integer> {

}
