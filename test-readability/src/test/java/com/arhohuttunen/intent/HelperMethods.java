package com.arhohuttunen.intent;

import com.arhohuttunen.Person;
import com.arhohuttunen.PersonBuilder;
import com.arhohuttunen.PersonRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.arhohuttunen.PersonBuilder.aPerson;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class HelperMethods {

    @Autowired
    private MockMvc client;
    @Autowired
    private PersonRepository personRepository;

    @BeforeEach
    void clearPersonRepository() {
        personRepository.deleteAll();
    }

    @Test
    void returnVerifiedPeople() throws Exception {
        havingPersisted(aPerson().withFirstName("Unverified Person"));
        havingPersisted(aPerson().withFirstName("Verified Person").whoIsVerified());

        List<Person> people = requestVerifiedPeople();

        assertThat(people).extracting("firstName").containsOnly("Verified Person");
    }

    private void havingPersisted(PersonBuilder personBuilder) {
        personRepository.save(personBuilder.build());
    }

    private List<Person> requestVerifiedPeople() throws Exception {
        String json = client.perform(get("/person?status=VERIFIED"))
                .andReturn().getResponse().getContentAsString();
        return toDto(json);
    }

    private List<Person> toDto(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, List.class);
    }
}
