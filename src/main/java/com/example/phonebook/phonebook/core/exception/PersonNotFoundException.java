package com.example.phonebook.phonebook.core.exception;

public class PersonNotFoundException extends RuntimeException {

    private final Long id;

    public PersonNotFoundException(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
