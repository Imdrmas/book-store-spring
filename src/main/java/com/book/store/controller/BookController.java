package com.book.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.store.modal.Book;
import com.book.store.service.BookService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/addBookToCategory/{id}")
	Book addBookToCategory(@RequestBody Book book, @PathVariable long id) {
		return bookService.addBookToCategory(book, id);
	}
	
	@PutMapping("/editBook/{id}/{idCategory}")
	Book editBook(@RequestBody Book book, @PathVariable long id, @PathVariable long idCategory) {
		return bookService.editBook(book, id, idCategory);
	}
	
	@DeleteMapping("/deleteBook/{id}")
	void deleteBook(@PathVariable long id) {
		bookService.deleteBook(id);
	}
	
	@GetMapping("/findBookByName/{name}")
	Book findBookByName(@PathVariable String name) {
		return bookService.findBookByName(name);
	}
	
	@GetMapping("/findBookById/{id}")
	Book findBookById(@PathVariable long id) {
		return bookService.findBookById(id);
	}
	
	@GetMapping("/findllBooks")
	List<Book> findllBooks() {
		return bookService.findllBooks();
	}
	
	@GetMapping("/findBooksForCategory/{id}")
	List<Book> findBooksForCategory(@PathVariable long id) {
		return bookService.findBooksForCategory(id);
	}

}
