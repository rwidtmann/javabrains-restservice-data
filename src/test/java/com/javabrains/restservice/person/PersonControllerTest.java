package com.javabrains.restservice.person;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    Person person;

    @MockBean
    PersonService personService;


    @Before
    public void setUp() throws Exception {
        Person person = new Person(22, "Yosomite", "Sam", 1);
    }

    @Test
    public void getAllPeople() throws Exception {
        List<Person> personList = Arrays.asList(
                new Person(55, "Donald", "Duck", 1),
                new Person(77, "Mickey", "Mouse", 1),
                new Person(88, "Super", "Dog", 1)
        );

        when(personService.getAllPeople())
                .thenReturn(personList);

        mockMvc.perform(get("/people")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].firstName", is("Donald")))
                .andExpect(jsonPath("$[1].lastName", is("Mouse")))
                .andExpect(status().isOk());

        verify(personService).getAllPeople();
    }

    @Test
    public void testing_doPrint_in_getAllPeople() throws Exception {
        List<Person> personList = Arrays.asList(
                new Person(55, "Donald", "Duck", 1),
                new Person(77, "Mickey", "Mouse", 1),
                new Person(88, "Super", "Dog", 1)
        );

        when(personService.getAllPeople())
                .thenReturn(personList);

        this.mockMvc.perform(get("/people"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[2].lastName", is("Dog")));
    }


    @Test
    public void addPerson() throws Exception {

        mockMvc.perform(post("/add-person")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content("{\n" +
                        "  \"id\": 55,\n" +
                        "  \"firstName\": \"Bill\",\n" +
                        "  \"lastName\": \"Murray\",\n" +
                        "  \"generationLevel\": 2\n" +
                        "}"))
                .andExpect(status().isOk());

        verify(personService).addPerson(any(Person.class));
    }

}

