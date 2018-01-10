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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    People person;

    @MockBean
    PersonService personService;


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getAllPeople() throws Exception {
        //People person = new People(55, "James", "Anderson", 1);
//        when(personService.getAllPeople())
//                .thenReturn(Collections.singletonList(person));
        List<People> peopleList = Arrays.asList(
                new People(55, "Donald", "Duck", 1),
                new People(77, "Mickey", "Mouse", 1),
                new People(88, "Super", "Dog", 1)
        );

        when(personService.getAllPeople())
                .thenReturn(peopleList);

        mockMvc.perform(get("/people")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].firstName", is("Donald")))
                .andExpect(jsonPath("$[1].lastName", is("Mouse")))
                .andExpect(status().isOk());

        verify(personService).getAllPeople();
    }


//    @Test
//    public void addPerson() {
//    }
}


//    @Test
//    public void doGet() throws Exception {
//        BenefitSummary benefitSummary = BenefitSummary.newBuilder().build();
//        when(benefitSummaryService.generate(any(String.class)))
//                .thenReturn(benefitSummary);
//
//        mockMvc.perform(get("/members/{uid}/spending-summary", "1"))
//                .andExpect(status().isOk());
//
//        verify(benefitSummaryService).generate(eq("1"));
//    }