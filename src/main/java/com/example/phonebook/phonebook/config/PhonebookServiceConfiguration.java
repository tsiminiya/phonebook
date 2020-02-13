package com.example.phonebook.phonebook.config;

import com.example.phonebook.phonebook.core.PersonGateway;
import com.example.phonebook.phonebook.core.PhonebookService;
import com.example.phonebook.phonebook.infrastructure.gateway.PersonGatewayImpl;
import com.example.phonebook.phonebook.infrastructure.repository.PersonEntityRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Profile("!test")
@EnableJpaRepositories("com.example.phonebook.phonebook.infrastructure.repository")
public class PhonebookServiceConfiguration {

    @Bean
    public PhonebookService phonebookService(PersonEntityRepository personEntityRepository) {
        return new PhonebookService(personGateway(personEntityRepository));
    }

    @Bean
    public PersonGateway personGateway(PersonEntityRepository personEntityRepository) {
        return new PersonGatewayImpl(personEntityRepository);
    }

}
