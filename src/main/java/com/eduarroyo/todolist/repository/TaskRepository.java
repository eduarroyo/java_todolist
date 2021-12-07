package com.eduarroyo.todolist.repository;

import com.eduarroyo.todolist.entity.Task;

import org.springframework.stereotype.Repository;

@Repository
public class TaskRepository extends JPARepository<Task, Long>{
    
}
