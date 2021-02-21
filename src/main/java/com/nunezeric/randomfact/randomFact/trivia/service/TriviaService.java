package com.nunezeric.randomfact.randomFact.trivia.service;

import com.nunezeric.randomfact.randomFact.randomfact.exception.ApiRequestException;
import com.nunezeric.randomfact.randomFact.trivia.model.Trivia;
import com.nunezeric.randomfact.randomFact.trivia.repository.TriviaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Eric Nunez
 */
@Service
public class TriviaService {

    private TriviaRepository triviaRepository;

    @Autowired
    public TriviaService(TriviaRepository triviaRepository) {
        this.triviaRepository = triviaRepository;
    }

    public Trivia getOneTrivia() {
        Long count = triviaRepository.count();

        int randomId = (int)(Math.random() * count) + 1;
        return triviaRepository
                .findById(randomId)
                .orElseThrow(() -> new ApiRequestException("There was a problem fetching a random trivia set."));
    }

    public List getMultipleTrivias(int quantity) {

        Long count = triviaRepository.count();

        if (quantity > count) {
            throw new ApiRequestException("You requested more trivia questions than are available.");
        }

        Page<Trivia> page =  triviaRepository.findAll(PageRequest.of(0,quantity));
        List<Trivia> list = page.getContent();
        return list;
    }

}
