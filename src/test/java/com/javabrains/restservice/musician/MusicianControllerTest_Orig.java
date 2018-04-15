package com.javabrains.restservice.musician;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static
        org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest(MusicianController.class)
public class MusicianControllerTest_Orig {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    Musician musician;

    @MockBean
    MusicianService musicianService;

    @Test
    public void doGet_endpoint_verification() throws Exception {
        mockMvc.perform(get("/get-all-musicians"))
                .andExpect(status().isOk());
    }

    @Test
    public void doGet_jsonPath_verifications() throws Exception{
        Musician joeWalsh = new Musician();

        List<Song> walshSongList = Arrays.asList(
                new Song(1, "Rocky Mountain Way", "Walsh", "1978", joeWalsh),
                new Song(1, "Take It Easy", "Walsh", "1979", joeWalsh)
        );

        List<Musician> musicians = Arrays.asList(
                new Musician(1, "Joe", "Walsh", walshSongList)
        );

        when(musicianService.getAllMusicians())
                .thenReturn(musicians);

        List<Musician> result = musicianService.getAllMusicians();

        mockMvc.perform(get("/get-all-musicians"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].musicianFirstName", is("Joe")))
                .andExpect(jsonPath("$[0].songList[1].songTitle", is("Take It Easy")))
        .andExpect(jsonPath("$[0].songList[0].songTitle", is("Rocky Mountain Way")));

        //assertThat(result.size()).isEqualTo(1);


    }


    @Test
    public void deleteMusician() throws Exception {

    }
}
