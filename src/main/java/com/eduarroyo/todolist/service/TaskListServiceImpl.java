package com.eduarroyo.todolist.service;

import java.util.Optional;

import com.eduarroyo.todolist.entity.TaskList;
import com.eduarroyo.todolist.repository.TaskListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
// import org.springframework.data.domain.Sort;
// import org.springframework.data.domain.Example;

@Service
public class TaskListServiceImpl implements TaskListService {

    @Autowired
    private TaskListRepository rep;

    @Override
    @Transactional(readOnly=true)
    public Iterable<TaskList> findAll() {
        return rep.findAll();
    }

    // @Override
    // @Transactional(readOnly=true)
    // public Iterable<TaskList> findByOwnerId(Long ownerId) {        
    //     return this.findByOwnerId(ownerId, Sort.by(Sort.Direction.DESC, "creationDate"));
    // }

    // @Override
    // @Transactional(readOnly=true)    
    // public Iterable<TaskList> findByOwnerId(Long ownerId, Sort sort) {
    //     TaskList tlExample = new TaskList();
    //     tlExample.setOwnerId(ownerId);
    //     Example<TaskList> example = Example.of(tlExample);
    //     return rep.findAll(example, sort);
    // }

    // @Override
    // @Transactional(readOnly=true)
    // public Page<TaskList> findByOwnerId(Long ownerId, int page, int pageSize) {
    //     Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.DESC, "creationDate");
    //     return this.findByOwnerId(ownerId, pageable);
    // }

    // @Override
    // @Transactional(readOnly=true)
    // public Page<TaskList> findByOwnerId(Long ownerId, int page, int pageSize, Sort sort) {
    //     Pageable pageable = PageRequest.of(page, pageSize, sort);
    //     return this.findByOwnerId(ownerId, pageable);
    // }

    // @Override
    // @Transactional(readOnly=true)
    // public Page<TaskList> findByOwnerId(Long ownerId, Pageable pageable) {
    //     TaskList tlExample = new TaskList();
    //     tlExample.setOwnerId(ownerId);
    //     Example<TaskList> example = Example.of(tlExample);

    //     return rep.findAll(example, pageable);
    // }

    @Override
    @Transactional(readOnly=true)
    public Page<TaskList> findAll(Pageable pageable) {
        return rep.findAll(pageable);
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<TaskList> findById(Long taskListId) {
        return rep.findById(taskListId);
    }

    @Override
    @Transactional
    public TaskList save(TaskList taskList) {
        return rep.save(taskList);
    }
    
    @Override
    @Transactional
    public void deleteById(Long taskListId) {
        rep.deleteById(taskListId);
    }
}