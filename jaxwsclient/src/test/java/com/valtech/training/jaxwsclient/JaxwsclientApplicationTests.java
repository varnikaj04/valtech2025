package com.valtech.training.jaxwsclient;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.jaxws.HelloWorld;
import com.valtech.training.jaxws.Movie;
import com.valtech.training.jaxws.webservices.MovieServiceWS;

@SpringBootTest
class JaxwsclientApplicationTests {
	
	@Autowired
	private MovieServiceWS movieServiceWS;
	
	@Autowired
	private HelloWorld helloWorld;

	@Test
	void contextLoads() {
		System.out.println(helloWorld.hello("Valtech"));
		
		movieServiceWS.createMovie(new Movie("Luka Chuppi", "Rom-Com", "Hindi", List.of("Kartik Aaryan", "Kriti Sanon")));
		movieServiceWS.createMovie(new Movie("3 Idiots", "Comedy", "Hindi", List.of("Aamir Khan", "Kareena Kapoor")));
		
		System.out.println(movieServiceWS.getAllMovies());
		
	}

}
