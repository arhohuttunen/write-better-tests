package com.arhohuttunen.intent;

import com.arhohuttunen.Person;
import com.arhohuttunen.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static com.arhohuttunen.PersonBuilder.aPerson;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class UnclearIntent {
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
        Person person1 = aPerson().withFirstName("John").build();
        Person person2 = aPerson().withFirstName("Jane").withStatus(Person.Status.VERIFIED).build();
        personRepository.save(person1);
        personRepository.save(person2);

        client.perform(get("/person?status=VERIFIED"))
                .andExpect(jsonPath("$.[0].firstName", is("Jane")))
                .andExpect(jsonPath("$.*", hasSize(1)));
    }
}
