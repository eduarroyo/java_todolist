package com.eduarroyo.todolist.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tasks")
public class Task {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long taskId;

    @ManyToOne(optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name="taskListId")
    private TaskList list;

    @Column(length=1024, nullable=false)
    private String description;

    @Column(nullable=false)
    private boolean done;

    @Column(nullable=false)
    private Date creationDate;

    @Column(nullable=true)
    private Date doneDate;

    public Task() {
        creationDate = new Date();
    }

    public Task(String description) {
        this();
        this.description = description;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (taskId ^ (taskId >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        
        Task other = (Task) obj;
        return taskId == other.taskId;
    }

    public long getTareaId() {
        return taskId;
    }

    public String getDescripcion() {
        return description;
    }

    public void setDescripcion(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(Date doneDate) {
        this.doneDate = doneDate;
    }   
}
