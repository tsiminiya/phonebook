package com.example.phonebook.phonebook.infrastructure.gateway;

import com.example.phonebook.phonebook.core.PersonGateway;
import com.example.phonebook.phonebook.core.model.Person;
import com.example.phonebook.phonebook.infrastructure.repository.PersonEntity;
import com.example.phonebook.phonebook.infrastructure.repository.PersonEntityRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonGatewayImpl implements PersonGateway {

    private final PersonEntityRepository personEntityRepository;

    public PersonGatewayImpl(PersonEntityRepository personEntityRepository) {
        this.personEntityRepository = personEntityRepository;
    }

    @Override
    public Optional<Person> getPerson(Long id) {
        return personEntityRepository.findById(id).map(this::toPerson);
    }

    @Override
    public List<Person> getPersonList() {
        return personEntityRepository.findAll().stream()
                .map(this::toPerson).collect(Collectors.toList());
    }

    @Override
    public List<Person> getPersonList(String keyword) {
        return personEntityRepository.findAll().stream()
                .filter(personEntity -> containsKeyword(personEntity, keyword))
                .map(this::toPerson).collect(Collectors.toList());
    }

    private boolean containsKeyword(PersonEntity personEntity, String keyword) {
        return (personEntity.getFirstName() != null && personEntity.getFirstName().contains(keyword)) ||
                (personEntity.getMiddleName() != null && personEntity.getMiddleName().contains(keyword)) ||
                (personEntity.getLastName() != null && personEntity.getLastName().contains(keyword));
    }

    private Person toPerson(PersonEntity personEntity) {
        return new Person(personEntity.getId(),
                personEntity.getFirstName(),
                personEntity.getMiddleName(),
                personEntity.getLastName(),
                personEntity.getContactNumber(),
                personEntity.getAddress());
    }

    @Override
    public Person updatePerson(Person person) {
        return savePerson(person);
    }

    @Override
    public Person savePerson(Person person) {
        PersonEntity personEntity = personEntityRepository.save(toPersonEntity(person));
        return toPerson(personEntity);
    }

    private PersonEntity toPersonEntity(Person person) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(person.getId());
        personEntity.setFirstName(person.getFirstName());
        personEntity.setMiddleName(person.getMiddleName());
        personEntity.setLastName(person.getLastName());
        personEntity.setContactNumber(person.getContactNumber());
        personEntity.setAddress(person.getAddress());
        return personEntity;
    }

    @Override
    public void deletePerson(Long id) {
        personEntityRepository.deleteById(id);
    }
}
