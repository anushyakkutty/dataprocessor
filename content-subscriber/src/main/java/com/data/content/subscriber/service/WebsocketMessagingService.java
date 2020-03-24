package com.data.content.subscriber.service;

import com.data.content.subscriber.model.Content;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WebsocketMessagingService {
    private final SimpMessagingTemplate template;

    public void send(Content content ) {
        template.convertAndSend("/topic/messages", content);
    }
}
