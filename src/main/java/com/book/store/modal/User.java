package com.book.store.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	
	private boolean admin;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Category> categories;

	public User() {
		super();
	}

	public User(String username, String password, boolean admin, List<Category> categories) {
		super();
		this.username = username;
		this.password = password;
		this.admin = admin;
		this.categories = categories;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public void addCategoryToUser(Category category) {
		if (getCategories() == null) {
			this.categories = new ArrayList<>();
		}
		getCategories().add(category);
		category.setUser(this);
	}

}
