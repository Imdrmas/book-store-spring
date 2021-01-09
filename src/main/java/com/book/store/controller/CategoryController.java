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

import com.book.store.modal.Category;
import com.book.store.service.CategoryService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/addCategoryToUser/{id}")
	Category addCategoryToUser(@RequestBody Category category, @PathVariable long id) {
		return categoryService.addCategoryToUser(category, id);
	}
	
	@PutMapping("/editCategory/{id}/{idUser}")
	Category editCategory(@RequestBody Category category, @PathVariable long id, @PathVariable long idUser) {
		return categoryService.editCategory(category, id, idUser);
	}
	
	@DeleteMapping("/deleteCategory/{id}")
	void deleteCategory(@PathVariable long id) {
		categoryService.deleteCategory(id);
	}
	
	@GetMapping("/findCategoryById/{id}")
	Category findCategoryById(@PathVariable long id) {
		return categoryService.findCategoryById(id);
	}
	
	@GetMapping("/findAllCategories")
	List<Category> findAllCategories() {
		return categoryService.findAllCategories();
	}
	
	@GetMapping("/findCategoriesForUser/{id}")
	List<Category> findCategoriesForUser(@PathVariable long id) {
		return categoryService.findCategoriesForUser(id);
	}


}
