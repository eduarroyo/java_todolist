package com.eduarroyo.todolist.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="task_lists")
public class TaskList {
    
    public static final String EntityName = "lista de tareas";
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long taskListId;

    // @Column(name="ownerId", insertable=false, updatable = false)
    // private long ownerId;

    @Column(length=256, nullable=false)
    private String title;

    @Column(nullable=false)
    private boolean archived;

    @Column(nullable=false)
    private Date creationDate;

    @Column(nullable=true)
    private Date archivedDate;

    @OneToMany(mappedBy="list", fetch=FetchType.EAGER)
    private List<Task> tasks;

    // @ManyToOne(fetch=FetchType.EAGER, optional=false)
    // @JoinColumn(name="ownerId")
    // private User owner;

    public TaskList() {
        this.creationDate = new Date();
    }

    public TaskList(String title/*, User owner*/) {
        this();
        this.title = title;
        //this.owner = owner;
    }

    // public Long getOwnerId() {
    //     return ownerId;
    // }

    // public void setOwnerId(Long ownerId) {
    //     this.ownerId = ownerId;
    // }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getArchivedDate() {
        return archivedDate;
    }

    // public User getOwner() {
    //     return owner;
    // }

    // public void setOwner(User owner) {
    //     this.owner = owner;
    // }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (taskListId ^ (taskListId >>> 32));
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
        TaskList other = (TaskList) obj;
        if (taskListId != other.taskListId)
            return false;
        return true;
    }    
}