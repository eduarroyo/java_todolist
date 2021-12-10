package com.eduarroyo.todolist.service;

import java.util.Optional;

import com.eduarroyo.todolist.entity.Task;
import com.eduarroyo.todolist.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Example;

@Service
public class TaskServiceImpl implements TaskService {
    
    @Autowired
    private TaskRepository rep;

    @Override
    @Transactional(readOnly=true)
    public Iterable<Task> findAll() {
        return rep.findAll();
    }
    
    @Override
    @Transactional(readOnly=true)
    public Page<Task> findAll(Pageable pageable) {
        return rep.findAll(pageable);
    }
    
    @Override
    @Transactional(readOnly=true)
    public Iterable<Task> findByTaskListId(Long taskListId) {        
        return this.findByTaskListId(taskListId, Sort.by(Sort.Direction.DESC, "creationDate"));
    }

    @Override
    @Transactional(readOnly=true)    
    public Iterable<Task> findByTaskListId(Long taskListId, Sort sort) {
        Task tExample = new Task();
        tExample.setTaskListId(taskListId);
        Example<Task> example = Example.of(tExample);
        return rep.findAll(example, sort);
    }

    @Override
    @Transactional(readOnly=true)
    public Page<Task> findByTaskListId(Long taskListId, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.DESC, "creationDate");
        return this.findByTaskListId(taskListId, pageable);
    }

    @Override
    @Transactional(readOnly=true)
    public Page<Task> findByTaskListId(Long taskListId, int page, int pageSize, Sort sort) {
        Pageable pageable = PageRequest.of(page, pageSize, sort);
        return this.findByTaskListId(taskListId, pageable);
    }

    @Override
    @Transactional(readOnly=true)
    public Page<Task> findByTaskListId(Long taskListId, Pageable pageable) {
        Task tExample = new Task();
        tExample.setTaskListId(taskListId);
        Example<Task> example = Example.of(tExample);

        return rep.findAll(example, pageable);
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Task> findById(Long taskId) {
        return rep.findById(taskId);
    }

    @Override
    @Transactional
    public Task save(Task task) {
        return rep.save(task);
    }
    
    @Override
    @Transactional
    public void deleteById(Long taskId) {
        rep.deleteById(taskId);
    }
}
