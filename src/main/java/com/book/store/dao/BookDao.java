package com.book.store.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.store.modal.Book;

public interface BookDao extends JpaRepository<Book, Long> {
	Optional<Book> findByName(String name);

}
