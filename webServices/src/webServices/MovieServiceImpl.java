package webServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieServiceImpl implements MovieService {
	
	private List<Movie> movies = new ArrayList<Movie>();
	
	@Override
	public List<Movie> getAllMovies(){
		return movies;
	}
	
	
	@Override
	public Movie getMovie(int id) {
		
//		Optional<Movie> empty = Optional.empty();							when no object present
//		Optional<Movie> noIdea = Optional.ofNullable(obj);					when doubt about object
//		Optional<Movie> available = Optional.of(new Movie());				when there has to be a movie
		
		Optional<Movie> movie = movies.stream().filter(f -> f.getId() == id).findFirst();
		if(movie.isPresent()) return movie.get();
		return new Movie();
	}
	
	@Override
	public void addMovie(Movie m) {
		movies.add(m);
	}
	
	@Override
	public void removeMovie(Movie m) {
		movies.remove(m);
	}

}
