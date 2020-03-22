package com.data.content.publisher;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContentPublisherApplication.class)
public class ContentPublisherApplicationTest {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }

}
