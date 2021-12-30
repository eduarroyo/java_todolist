package com.eduarroyo.todolist.exceptions;

public abstract class TodoListException extends Throwable {

    private String messagePattern;
    private Object[] messageData;

    protected TodoListException(String messagePattern, Object[] messageData) {
        this(messagePattern, messageData, null);
    }

    protected TodoListException(String messagePattern, Object[] messageData, Throwable exception) {
        super(exception);
        this.messageData = messageData;
        this.messagePattern = messagePattern;
    }

    protected TodoListException(String message, Throwable exception) {
        super(message, exception);
    }

    protected TodoListException(String message) {
        super(message);
    }

    protected TodoListException(Throwable exception) {
        super(exception);
    }

    @Override
    public String getMessage() {
        if(messagePattern.length() > 0) {
            return String.format(messagePattern, messageData);
        } else {
            return super.getMessage();
        }
    }
}