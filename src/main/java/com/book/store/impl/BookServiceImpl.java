package com.book.store.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.book.store.dao.BookDao;
import com.book.store.dao.CategoryDao;
import com.book.store.modal.Book;
import com.book.store.modal.Category;
import com.book.store.service.BookService;

@Transactional
@Component
public class BookServiceImpl implements BookService {

	@Autowired
	private  BookDao bookDao;
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public Book addBookToCategory(Book book, long id) {
		Category category = categoryDao.findById(id).orElse(null);
		book.setPublishDate(new Date());
		category.addBookToCategory(book);
		return bookDao.save(book);
	}

	@Override
	public Book editBook(Book book, long id, long idCategory) {
		Book existsBook = bookDao.findById(id).orElse(null);
		Category category = categoryDao.findById(idCategory).orElse(null);
		existsBook.setName(book.getName());
		existsBook.setDescription(book.getDescription());
		existsBook.setPrice(book.getPrice());
		existsBook.setPhoto(book.getPhoto());
		existsBook.setLangue(book.getLangue());
		existsBook.setPublishDate(new Date());
		existsBook.setSize(book.getSize());
		existsBook.setPage(book.getPage());
		existsBook.setWriter(book.getWriter());
		existsBook.setPublisher(book.getPublisher());
		category.addBookToCategory(existsBook);
		return bookDao.save(existsBook);
	}

	@Override
	public void deleteBook(long id) {
		bookDao.deleteById(id);
	}

	@Override
	public Book findBookByName(String name) {
		Optional<Book> books = bookDao.findByName(name);
		if (books.isPresent()) {
			Book book = books.get();
			return book;
		}
		return null;
	}

	@Override
	public Book findBookById(long id) {
		return bookDao.findById(id).orElse(null);
	}

	@Override
	public List<Book> findllBooks() {
		return bookDao.findAll();
	}

	@Override
	public List<Book> findBooksForCategory(long id) {
		Category category = categoryDao.findById(id).orElse(null);
		return category.getBooks();
	}
	
	
}

