package de.neuefische.ffmjava232diandspringdata;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepo repo;

    public List<Person> getAllPersons() {
        return repo.findAll();
    }

    public Person getPersonById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public Person savePerson(NewPerson person){
        return repo.save(new Person(UUID.randomUUID().toString(), person.name()));
    }


}
