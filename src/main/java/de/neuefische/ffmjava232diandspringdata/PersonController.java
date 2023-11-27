package de.neuefische.ffmjava232diandspringdata;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;


    @GetMapping
    public List<Person> getAllPersons(){
        return service.getAllPersons();
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable String id){
        return service.getPersonById(id);
    }

    @PostMapping
    public Person savePerson(@RequestBody NewPerson person){
        return service.savePerson(person);
    }

//    @GetMapping("/find/{name}")
//    public Person findByName(@PathVariable String name){
//        return service.findByName(name);
//    }
}
