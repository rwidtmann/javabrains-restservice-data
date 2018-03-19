package com.javabrains.restservice.artist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ArtistController.class)
public class ArtistControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Artist artist;

    @MockBean
    private ArtistService artistService;

    @Test
    public void confirmEndpoint() throws Exception {
        mockMvc.perform(get("/all-artists"))
                .andExpect(status().isOk());
    }

    @Test
    public void getArtists_returns_list_of_artists() throws Exception {
        List<Artist> artistList = Arrays.asList(
                new Artist("Todd", "Rundgren", null),
                new Artist("Bruce", "Springstein", null)
        );

        when(artistService.getAllArtists())
                .thenReturn(artistList);

        mockMvc.perform(get("/all-artists"))
                .andExpect(jsonPath("$[0].artistLastName", is("Rundgren")))
                .andExpect(jsonPath("$[1].artistFirstName", is("Bruce")))
                .andExpect(status().isOk());

        verify(artistService).getAllArtists();

    }
}