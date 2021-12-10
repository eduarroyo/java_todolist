package com.eduarroyo.todolist.service;

import java.util.Optional;

import com.eduarroyo.todolist.entity.Task;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface TaskService {    
    public Iterable<Task> findAll();
    public Iterable<Task> findByTaskListId(Long taskListId);
    public Iterable<Task> findByTaskListId(Long taskListId, Sort sort);
    public Page<Task> findByTaskListId(Long taskListId, int page, int pageSize);
    public Page<Task> findByTaskListId(Long taskListId, int page, int pageSize, Sort sort);
    public Page<Task> findByTaskListId(Long taskListId, Pageable pageable);
    public Page<Task> findAll(Pageable pageable);
    public Optional<Task> findById(Long taskId);
    public Task save(Task task);
    public void deleteById(Long taskId);
}