package com.example.phonebook.phonebook.core;

import com.example.phonebook.phonebook.core.exception.PersonNotFoundException;
import com.example.phonebook.phonebook.core.model.Person;

import java.util.List;

public class PhonebookService {

    private final PersonGateway personGateway;

    public PhonebookService(PersonGateway personGateway) {
        this.personGateway = personGateway;
    }

    public Person getPerson(Long id) {
        return personGateway.getPerson(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    public List<Person> getPersonList(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return personGateway.getPersonList();
        }
        return personGateway.getPersonList(keyword);
    }

    public Person savePerson(Person person) {
        return personGateway.savePerson(person);
    }

    public Person updatePerson(Long id, Person person) {
        return personGateway.updatePerson(person.withId(id));
    }

    public void deletePerson(Long id) {
        if (personExists(id)) {
            personGateway.deletePerson(id);
        }
        throw new PersonNotFoundException(id);
    }

    private boolean personExists(Long id) {
        return personGateway.getPerson(id).isPresent();
    }

}
