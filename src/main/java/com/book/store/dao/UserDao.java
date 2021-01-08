package com.book.store.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.store.modal.User;

public interface UserDao extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

}

