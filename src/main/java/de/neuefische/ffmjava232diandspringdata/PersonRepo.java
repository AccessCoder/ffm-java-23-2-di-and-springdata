package de.neuefische.ffmjava232diandspringdata;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PersonRepo extends MongoRepository<Person, String> {

//    public Optional<Person> findByName(String name);

    List<Person> findByName(String name);
}
