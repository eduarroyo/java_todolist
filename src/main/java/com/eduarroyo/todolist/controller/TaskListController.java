package com.eduarroyo.todolist.controller;

import java.util.Optional;

import com.eduarroyo.todolist.entity.TaskList;
import com.eduarroyo.todolist.service.TaskListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/taskslists")
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

    @GetMapping()
    public ResponseEntity<Iterable<TaskList>> readAll() {
        // Cuando tengamos lista la autenticación, cargaremos sólo las listas del usuario actual.
        //Optional<TaskList> oTaskList = taskListService.findByOwnerId(currentUserId);
        Iterable<TaskList> taskList = taskListService.findAll();
        return ResponseEntity.ok(taskList);
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

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskList> delete(@PathVariable(value="id") Long taskListId) {
        Optional<TaskList> otl = taskListService.findById(taskListId);
        if(otl.isPresent()) {
            taskListService.deleteById(taskListId);
            return ResponseEntity
                .status(HttpStatus.OK)
                .build();
        } else {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskList> update(@PathVariable(value="id") Long taskListId, @RequestBody String title) {
        
        Optional<TaskList> otl = taskListService.findById(taskListId);

        if(otl.isEmpty()) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();
        }

        TaskList tl = otl.get();
        tl.setTitle(title);
        taskListService.save(tl);
        return ResponseEntity.ok(tl);
    }
}