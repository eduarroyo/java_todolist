package com.eduarroyo.todolist.service;

import java.util.Optional;

import com.eduarroyo.todolist.entity.TaskList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;

public interface TaskListService {
    // public Iterable<TaskList> findByOwnerId(Long ownerId);
    // public Iterable<TaskList> findByOwnerId(Long ownerId, Sort sort);
    // public Page<TaskList> findByOwnerId(Long ownerId, int page, int pageSize);
    // public Page<TaskList> findByOwnerId(Long ownerId, int page, int pageSize, Sort sort);
    // public Page<TaskList> findByOwnerId(Long ownerId, Pageable pageable);
    public Iterable<TaskList> findAll();
    public Page<TaskList> findAll(Pageable pageable);
    public Optional<TaskList> findById(Long taskListId);
    public TaskList save(TaskList taskList);
    public void deleteById(Long taskListId);
}
