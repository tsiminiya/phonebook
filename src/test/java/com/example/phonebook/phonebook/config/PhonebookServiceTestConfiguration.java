package com.example.phonebook.phonebook.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Profile;

@Profile("test")
@TestConfiguration
public class PhonebookServiceTestConfiguration {

}
