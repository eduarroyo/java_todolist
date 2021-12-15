package com.eduarroyo.todolist.controller;

import java.util.Optional;

import com.eduarroyo.todolist.entity.TaskList;
import com.eduarroyo.todolist.service.TaskListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public class TaskListController {
    
    @Autowired
    private TaskListService taskListService;

    //Create new user
    @PostMapping
    public ResponseEntity<TaskList> create(@RequestBody String title) {

        TaskList taskList = new TaskList();
        taskList.setTitle(title);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(taskListService.save(taskList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskList> read(@PathVariable(value="id") Long taskListId) {
        Optional<TaskList> oTaskList = taskListService.findById(taskListId);

        if(oTaskList.isEmpty()) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();
        }
            
        return ResponseEntity.ok(oTaskList.get());
    }
}
