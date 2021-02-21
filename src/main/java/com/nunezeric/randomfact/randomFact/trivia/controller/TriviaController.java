package com.nunezeric.randomfact.randomFact.trivia.controller;

import com.nunezeric.randomfact.randomFact.randomfact.exception.ApiRequestException;
import com.nunezeric.randomfact.randomFact.trivia.model.Trivia;
import com.nunezeric.randomfact.randomFact.trivia.service.TriviaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Eric Nunez
 */
@RestController("trivia")
public class TriviaController {

    private TriviaService triviaService;

    @Autowired
    public TriviaController(TriviaService triviaService) {
        this.triviaService = triviaService;
    }

    @GetMapping("trivia")
    public Trivia getOneTrivia() {
        return triviaService.getOneTrivia();
    }

    @GetMapping("trivia/{quantity}")
    public List getRandomTrivia(@PathVariable("quantity") String quantity) {
        int parsedQuantity;
        try{
            parsedQuantity = Integer.parseInt(quantity);
        } catch (NumberFormatException e) {
            throw new ApiRequestException("There was a problem with the parameter that you entered!");
        }
        return triviaService.getMultipleTrivias(parsedQuantity);
    }
}
