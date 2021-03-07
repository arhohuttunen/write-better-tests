package com.arhohuttunen;

import java.util.List;

public interface PersonRepository {
    void save(Person person);
    List<Person> findByStatus(Person.Status status);
    void deleteAll();
}
