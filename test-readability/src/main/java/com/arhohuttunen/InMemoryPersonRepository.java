package com.arhohuttunen;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class InMemoryPersonRepository implements PersonRepository {
    private final List<Person> persons = new ArrayList<>();

    @Override
    public void save(Person person) {
        persons.add(person);
    }

    @Override
    public List<Person> findByStatus(Person.Status status) {
        return persons.stream().filter(person -> person.getStatus().equals(status)).collect(Collectors.toList());
    }

    @Override
    public void deleteAll() {
        persons.clear();
    }
}
