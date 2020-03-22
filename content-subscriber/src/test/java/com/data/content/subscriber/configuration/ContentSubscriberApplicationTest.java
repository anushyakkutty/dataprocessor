package com.data.content.subscriber.configuration;

import com.data.content.subscriber.ContentSubscriberApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContentSubscriberApplication.class)
class ContentSubscriberApplicationTest {
    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}
