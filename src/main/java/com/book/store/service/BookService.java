package com.book.store.service;

import java.util.List;

import com.book.store.modal.Book;

public interface BookService {

	Book addBookToCategory(Book book, long id);
	
	Book editBook(Book book, long id, long idCategory);
	
	void deleteBook(long id);
	
	Book findBookByName(String name);
	
	Book findBookById(long id);
	
	List<Book> findllBooks();
	
	List<Book> findBooksForCategory(long id);
}
