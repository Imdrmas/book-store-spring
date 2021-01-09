package com.book.store.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.book.store.dao.UserDao;
import com.book.store.modal.User;
import com.book.store.service.UserService;

@Transactional
@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User addUser(User user) {
		List<User> users = userDao.findAll();
		if (users.size() == 0) {
			user.setAdmin(true);
		} else {
			user.setAdmin(false);
		}
		return userDao.save(user);
	}

	@Override
	public User editUser(User user, long id) {
		User userExistsUser = userDao.findById(id).orElse(null);
		userExistsUser.setAdmin(user.isAdmin());
		userExistsUser.setUsername(user.getUsername());
		userExistsUser.setPassword(user.getPassword());
		return userDao.save(userExistsUser);
	}

	@Override
	public void deleteUser(long id) {
		userDao.deleteById(id);
	}

	@Override
	public User findByUsername(String username) {
		Optional<User> users = userDao.findByUsername(username);
		if (users.isPresent()) {
			User user = users.get();
			return user;
		}
		return null;
	}

}
