package com.javabrains.restservice.person;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTest {

    @MockBean
    PersonService personService;

    @Autowired
    MockMvc mockMvc;

    public void getAllPeople() throws Exception {
        mockMvc.perform(get("/people")
                .contentType(MediaType.APPLICATION_JSON))
                //.content("{}"))
                .andExpect(status().isCreated());
    }
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


//    @Test
//    public void doPost() throws Exception {
//        when(benefitSummaryService.generate(any(BenefitSummaryQuery.class)))
//                .thenReturn(BenefitSummary
//                        .newBuilder()
//                        .build());
//
//        mockMvc.perform(post("/spending-summary")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{}"))
//                .andExpect(status().isCreated());
//
//        verify(benefitSummaryService).generate(isA(BenefitSummaryQuery.class));
//    }
