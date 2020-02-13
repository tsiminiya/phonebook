package com.example.phonebook.phonebook.presentation;

import com.example.phonebook.phonebook.PhonebookApplication;
import com.example.phonebook.phonebook.config.PhonebookServiceTestConfiguration;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.mapper.factory.DefaultJackson1ObjectMapperFactory;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {
        PhonebookApplication.class,
        PhonebookServiceTestConfiguration.class
})
public class PhonebookTest {

    @LocalServerPort
    private Integer port;

    @BeforeEach
    public void initialize() {
        RestAssured.port = port;

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();

        RestAssured.config = RestAssured.config()
                .objectMapperConfig(new ObjectMapperConfig()
                        .jackson1ObjectMapperFactory(new DefaultJackson1ObjectMapperFactory()));
    }

}
