package com.book.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.store.modal.Category;

public interface CategoryDao extends JpaRepository<Category, Long>{

}
