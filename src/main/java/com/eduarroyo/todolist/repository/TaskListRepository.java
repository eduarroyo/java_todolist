package com.eduarroyo.todolist.repository;

import com.eduarroyo.todolist.entity.TaskList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskListRepository extends JpaRepository<TaskList, Long>{
}
