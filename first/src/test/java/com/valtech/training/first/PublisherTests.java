package com.valtech.training.first;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.first.services.BookService;
import com.valtech.training.first.services.PublisherService;

@SpringBootTest
public class PublisherTests {

	@Autowired
	private PublisherService publisherService;
	
	@Autowired
	private BookService bookService;
	
	@Test
	void getAllPublishers() {
		assertEquals(3, publisherService.getAllPublishers().size());
	}
	
	@Test
	void testBookStore() {
		assertEquals(4, bookService.getBooksByYearBetween(2000,2006).size());
		assertEquals(3, bookService.getBooksByPriceGreaterThan(100).size());
		assertEquals(2, bookService.getBooksByAuthorsId(2).size());
		assertEquals(2, bookService.getAllPriceByAuthorsId(2).size());
		System.out.println(bookService.getAllPriceByAuthorsId(2));
		System.out.println(bookService.getBookInfoByAuthor(2));
	}
}
