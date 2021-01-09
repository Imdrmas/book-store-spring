package com.book.store.service;

import java.util.List;

import com.book.store.modal.Category;

public interface CategoryService {
	
	Category addCategoryToUser(Category category, long id);
	
	Category editCategory(Category category, long id, long idUser);
	
	void deleteCategory(long id);
	
	Category findCategoryById(long id);
	
	List<Category> findAllCategories();
	
	List<Category> findCategoriesForUser(long id);

}
