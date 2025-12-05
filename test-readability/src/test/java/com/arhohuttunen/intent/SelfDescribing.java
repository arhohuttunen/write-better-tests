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
class SelfDescribing {
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
        Person unverifiedPerson = aPerson().withFirstName("Unverified Person").build();
        Person verifiedPerson = aPerson().withFirstName("Verified Person").whoIsVerified().build();
        personRepository.save(unverifiedPerson);
        personRepository.save(verifiedPerson);

        client.perform(get("/person?status=VERIFIED"))
                .andExpect(jsonPath("$.[0].firstName", is("Verified Person")))
                .andExpect(jsonPath("$.*", hasSize(1)));
    }
}
