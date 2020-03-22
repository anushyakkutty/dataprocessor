package com.data.content.publisher.controller;

import com.data.content.publisher.service.ContentPublisherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class ContentControllerTest {

    @MockBean
    private ContentPublisherService userRepository;

    @Autowired
    ContentController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenControllerInjected_thenNotNull() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void whenContentControllerPostTest() throws Exception {
        String user = "{\"content\": \"malayalam\", \"timestamp\" : \"2018-10-09 00:12:12+0100\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/content")
                .content(user)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void whenContentControllerPostWithINvalidDateTest() throws Exception {
        String user = "{\"content\": \"malayalam\", \"timestamp\" : \"2018-10-09\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/content")
                .content(user)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void whenContentControllerPostWithInvalidCOntentTest() throws Exception {
        String user = "{\"content\": \"\", \"timestamp\" : \"2018-10-09 00:12:12+0100\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/content")
                .content(user)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
