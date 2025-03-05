package com.valtech.training.first.services;

import java.util.List;

import com.valtech.training.first.dtos.BookInfoDTO;
import com.valtech.training.first.entities.Book;


public interface BookService {
	
	List<Book> getAllBooks();
	
	long countAllBooks();

	List<Book> getBooksByYearBetween(int i, int j);

	List<Book> getBooksByPriceGreaterThan(int i);
	
	List<Book> getBooksByAuthorsId(int authorId);
	
	List<Integer> getAllPriceByAuthorsId(int id);
	
	List<BookInfoDTO> getBookInfoByAuthor(int id);

}
