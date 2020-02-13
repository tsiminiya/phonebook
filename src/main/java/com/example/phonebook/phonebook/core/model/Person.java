package com.example.phonebook.phonebook.core.model;

import java.util.Objects;

public class Person {

    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String contactNumber;
    private String address;

    public Person() {
    }

    public Person(Long id, String firstName, String middleName, String lastName, String contactNumber, String address) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public Person withId(Long id) {
        return new Person(id, firstName, middleName, lastName, contactNumber, address);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(middleName, person.middleName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(contactNumber, person.contactNumber) &&
                Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, middleName, lastName, contactNumber, address);
    }
}
