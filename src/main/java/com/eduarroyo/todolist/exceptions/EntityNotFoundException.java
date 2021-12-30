package com.eduarroyo.todolist.exceptions;

public class EntityNotFoundException extends TodoListException {

    private String id;
    private String entityName;

    public EntityNotFoundException(String entityName, String id) {
        super("No existe el/la %s identificada por %s", new Object[] {entityName, id});
        this.id=id;
        this.entityName=entityName;
    }

    public EntityNotFoundException(String entityName, String id, Throwable exception) {
        super("No existe el/la %s identificada por %s", new Object[] {entityName, id}, exception);
        this.id=id;
        this.entityName=entityName;
    }

    public String getId() {
        return id;
    }

    public String getEntityName() {
        return entityName;
    }
}
