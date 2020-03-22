package com.data.content.publisher.messagingservice;

import com.data.content.subscriber.ContentSubscriberApplication;
import com.data.content.subscriber.controller.ContentController;
import com.data.content.subscriber.service.ContentService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    public void whenControllerInjected_thenNotNull() throws Exception {
        assertThat(controller).isNotNull();
    }
}
