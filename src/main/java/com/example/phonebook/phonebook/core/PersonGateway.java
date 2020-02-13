package com.example.phonebook.phonebook.core;

import com.example.phonebook.phonebook.core.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonGateway {

    Optional<Person> getPerson(Long id);

    List<Person> getPersonList();

    List<Person> getPersonList(String keyword);

    Person savePerson(Person person);

    Person updatePerson(Person person);

    void deletePerson(Long id);

}
