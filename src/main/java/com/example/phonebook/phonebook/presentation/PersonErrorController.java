package com.example.phonebook.phonebook.presentation;

import com.example.phonebook.phonebook.core.exception.InvalidPersonIdException;
import com.example.phonebook.phonebook.core.exception.PersonNotFoundException;
import com.example.phonebook.phonebook.core.model.PersonError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PersonErrorController {

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<Object> handlePersonNotFound(PersonNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new PersonError("Unable to find person with ID " + e.getId()));
    }

    @ExceptionHandler(InvalidPersonIdException.class)
    public ResponseEntity<Object> handleInvalidPerson(InvalidPersonIdException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new PersonError("Invalid person ID"));
    }

}
