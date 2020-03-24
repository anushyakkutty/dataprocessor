package com.data.content.subscriber.controller;

import com.data.content.subscriber.controller.ContentController;
import com.data.content.subscriber.model.Content;
import com.data.content.subscriber.repository.ContentRepository;
import com.data.content.subscriber.service.ContentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class ContentControllerTest {

    @MockBean
    private ContentService service;

    @Autowired
    ContentController controller;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContentRepository repo;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void whenControllerInjected_thenNotNull() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void testGET() throws Exception {
        when(repo.findAll()).thenReturn(List.of(new Content("1", "malayalam", "2018-10-08 23:12:12+000", 5)));
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/palindromes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
