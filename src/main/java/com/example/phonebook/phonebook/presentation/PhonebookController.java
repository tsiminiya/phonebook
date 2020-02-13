package com.example.phonebook.phonebook.presentation;

import com.example.phonebook.phonebook.core.PhonebookService;
import com.example.phonebook.phonebook.core.model.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phonebook")
public class PhonebookController {

    private final PhonebookService phonebookService;

    public PhonebookController(PhonebookService phonebookService) {
        this.phonebookService = phonebookService;
    }

    @GetMapping
    public ResponseEntity<Person> getPerson(@RequestParam("id") Long id) {
        return ResponseEntity.ok(phonebookService.getPerson(id));
    }

    @GetMapping
    public ResponseEntity<List<Person>> getPersonList(@RequestParam("keyword") String keyword) {
        return ResponseEntity.ok(phonebookService.getPersonList(keyword));
    }

    @PostMapping
    public ResponseEntity<?> savePerson(@RequestBody Person person) {
        return ResponseEntity.ok(phonebookService.savePerson(person));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updatePerson(@PathVariable("id") Long id, @RequestBody Person person) {
        return ResponseEntity.ok(phonebookService.updatePerson(id, person));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePerson(@PathVariable("id") Long id) {
        phonebookService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }

}
