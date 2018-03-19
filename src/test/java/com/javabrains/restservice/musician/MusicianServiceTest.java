package com.javabrains.restservice.musician;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

//import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;


//@RunWith(MockitoJUnitRunner.class)
public class MusicianServiceTest {

//    @MockBean
//    MusicianRepository musicianRepository;
//
//    @InjectMocks
//    MusicianService musicianService;

//    @Test
//    //@Ignore
//    public void getAllMusicians() throws Exception {
//        List<Musician> musicians = Arrays.asList(
//                new Musician(1, "Todd", "Rundgren", "Hermit of Mink Hallow"),
//                new Musician(2, "Bruce", "Springstein", "Born In The Usa")
//        );
//
//        when(musicianRepository.findAll())
//                .thenReturn(musicians);
//
//        List<Musician> result = musicianService.getAllMusicians();
//
//        assertThat(result)
//                .size().isEqualTo(2);
//
//        assertThat(result.get(1).getAlbumMusician().equals("Born In The Usa"));
//
//        assertThat(result.get(0).getAlbumMusician())
//                .contains("Hermit");
//
//        verify(musicianRepository).findAll();
//    }

//    @Test
//    public void getMusicianLastName(String name) {
//        Musician musician = new Musician(3, "Bryan", "Adams", "Cuts Like a Knife");
//
//        when(musicianRepository.findOne(String.class))
//                .thenReturn(musician);
//
//        Musician result = musicianService.getMusicianLastName(name);
//
//        assertThat(result.getMusicianFirstName().equals("Bryan"));
//    }
}