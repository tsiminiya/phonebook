package com.example.phonebook.phonebook.core.model;

public class PersonError {

    private String message;

    public PersonError() {
    }

    public PersonError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
