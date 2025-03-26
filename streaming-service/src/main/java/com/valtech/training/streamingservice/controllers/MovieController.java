package com.valtech.training.streamingservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.streamingservice.services.MovieService;
import com.valtech.training.streamingservice.vos.MovieVO;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
	
	@Autowired
	private MovieService movieService;

	@PostMapping("/")
	public MovieVO createMovie(@RequestBody MovieVO vo) {
		return movieService.createorUpdateMovie(vo);
	}
	
	@GetMapping("/")
	public List<MovieVO> getAllMovies(){
		return movieService.getAllMovies();
	}
	
	@GetMapping("/{id}")
	public MovieVO getMovieById(@PathVariable("id") long id) {
		return movieService.getMovie(id);
	}
	
	@GetMapping("/genre/{genre}")
	public List<MovieVO> getAllMoviesByGenre(@PathVariable("genre") String genre){
		return movieService.getMoviesByGenre(genre);
	}
	
	@GetMapping("/genre/{genre}/language/{language}")
	public List<MovieVO> getMoviesByGenreAndLanguage(@PathVariable("genre") String genre, @PathVariable("language") String language){
		return movieService.getMoviesByGenreAndLanguage(genre, language);
	}
	
}
