package com.book.store.service;

import com.book.store.modal.User;

public interface UserService {
	User addUser(User user);

	User editUser(User user, long id);

	void deleteUser(long id);

	User findByUsername(String username);
}
