package de.neuefische.ffmjava232diandspringdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class PersonControllerTest {

    private final String BASE_URL = "/api/person";

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper; // -> Macht aus Objekten JSON´s und anders herum!
    @Test
    void getAllPersons_shouldReturnEmptyList_WhenCalledInitially() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(BASE_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]"));
    }

    @Test
    void getById_shouldReturnNewPerson_WhenCalledWithValidId() throws Exception {
        //BLACKBOX Test

        //GIVEN
        NewPerson person = new NewPerson("name");
        String newPersonAsJSON = objectMapper.writeValueAsString(person);

        MvcResult result = mvc.perform(MockMvcRequestBuilders.post(BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(newPersonAsJSON))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Person savedPerson = objectMapper.readValue(result.getResponse().getContentAsString(), Person.class);
        String PersonAsJSON = objectMapper.writeValueAsString(savedPerson);

        //WHEN+THEN
        mvc.perform(MockMvcRequestBuilders.get(BASE_URL+"/"+savedPerson.id()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(PersonAsJSON));
    }

    @Test
    void savePerson() {
    }

    @Test
    void findByName() {
    }
}