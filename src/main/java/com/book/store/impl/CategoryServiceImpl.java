package com.book.store.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.book.store.dao.CategoryDao;
import com.book.store.dao.UserDao;
import com.book.store.modal.Category;
import com.book.store.modal.User;
import com.book.store.service.CategoryService;

@Transactional
@Component
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private UserDao userDao;

	@Override
	public Category addCategoryToUser(Category category, long id) {
		User user = userDao.findById(id).orElse(null);
		List<Category> categories = categoryDao.findAll();
		if (categories.size()==0) {
			category.setExpanded(true);
		} else {
			category.setExpanded(false);
		}
		user.addCategoryToUser(category);
		return categoryDao.save(category);
	}

	@Override
	public Category editCategory(Category category, long id, long idUser) {
		Category existCategory = categoryDao.findById(id).orElse(null);
		User user = userDao.findById(idUser).orElse(null);
		existCategory.setName(category.getName());
		user.addCategoryToUser(existCategory);
		return categoryDao.save(existCategory);
	}

	@Override
	public void deleteCategory(long id) {
		categoryDao.deleteById(id);		
	}

	@Override
	public Category findCategoryById(long id) {
		return categoryDao.findById(id).orElse(null);
	}

	@Override
	public List<Category> findAllCategories() {
		return categoryDao.findAll();
	}

	@Override
	public List<Category> findCategoriesForUser(long id) {
		User user = userDao.findById(id).orElse(null);
		return user.getCategories();
	}

}
