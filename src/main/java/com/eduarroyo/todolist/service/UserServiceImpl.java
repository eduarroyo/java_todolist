package com.eduarroyo.todolist.service;

import java.util.Optional;

import com.eduarroyo.todolist.entity.User;
import com.eduarroyo.todolist.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository rep;

    @Override
    @Transactional(readOnly=true)
    public Iterable<User> findAll() {
        return rep.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Page<User> findAll(Pageable pageable) {
        return rep.findAll(pageable);
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<User> findById(Long userId) {
        return rep.findById(userId);
    }

    @Override
    @Transactional
    public User save(User user) {
        return rep.save(user);
    }
    
    @Override
    @Transactional
    public void deleteById(Long userId) {
        rep.deleteById(userId);
    }
}