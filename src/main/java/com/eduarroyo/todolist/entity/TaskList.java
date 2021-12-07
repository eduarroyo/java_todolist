package com.eduarroyo.todolist.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="task_lists")
public class TaskList {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long taskListId;

    @Column(length=256, nullable=false)
    private String title;

    @OneToMany(mappedBy="list", fetch=FetchType.EAGER)
    private List<Task> tasks;

    @ManyToOne(fetch=FetchType.EAGER, optional=false)
    @JoinColumn(name="ownerId")
    private User owner;
}