package com.data.content.subscriber.service;

import com.data.content.subscriber.model.Content;
import com.data.content.subscriber.repository.ContentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageSubscriberService implements MessageListener  {
    private final WebsocketMessagingService websocketMessagingService;
    ObjectMapper objectMapper = new ObjectMapper();

    private final ContentRepository contentRepo;

    public void onMessage(final Message message, final byte[] pattern) {
        Content content = null;
        try {
             content = objectMapper.readValue(message.toString(), Content.class);
            contentRepo.save(content);
            System.out.println("Message received: " + new String(message.getBody()));
        } catch (IOException e) {
            log.error("Exception while trying to read a message from topic.");
        }

        if (content != null) {
            websocketMessagingService.send(content);
        }
    }
}
