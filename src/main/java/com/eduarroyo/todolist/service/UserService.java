package com.eduarroyo.todolist.service;

import java.util.Optional;

import com.eduarroyo.todolist.entity.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    
    public Iterable<User> findAll();
    public Page<User> findAll(Pageable pageable);
    public Optional<User> findById(Long userId);
    public User save(User user);
    public void deleteById(Long userId);
}
