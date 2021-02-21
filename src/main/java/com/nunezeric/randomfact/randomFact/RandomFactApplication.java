package com.nunezeric.randomfact.randomFact;

import com.nunezeric.randomfact.randomFact.randomfact.model.Category;
import com.nunezeric.randomfact.randomFact.randomfact.model.RandomFact;
import com.nunezeric.randomfact.randomFact.randomfact.repository.RandomFactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RandomFactApplication {

	public static void main(String[] args) {
		SpringApplication.run(RandomFactApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner demo(RandomFactRepository randomFactRepository){
//		return args -> {
//			randomFactRepository.save((new RandomFact(1, "In the Godfather movies, oranges represent an upcoming death.",Category.movies)));
//			randomFactRepository.save((new RandomFact(2,"In the movie, ‘Star Wars’, during the scene in which Luke gets out of his X-wing fighter after blowing up the Death Star, he accidentally calls Princess Leia ‘Carrie’ (her real first name).",Category.movies)));
//			randomFactRepository.save((new RandomFact(3,"In “Casablanca”, Humphrey Bogart never said “Play it again, Sam”.",Category.movies)));
//			randomFactRepository.save((new RandomFact(4,"James Bond author Ian Fleming also wrote the childrens novel Chitty Chitty Bang Bang.",Category.movies)));
//			randomFactRepository.save((new RandomFact(5,"King Kong is the first movie to have its sequel -- Son of Kong -- released the same year (1933).",Category.movies)));
//			randomFactRepository.save(new RandomFact(6,"Football was the first team sport added to the Olympics in 1900.",Category.sports));
//		};
//	}

}
