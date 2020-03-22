package com.data.content.publisher.service;

import com.data.content.publisher.model.Content;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisContentPublisherService implements  ContentPublisherService {
    private  final RedisTemplate redisTemplate;
    private final ChannelTopic topic;

    @Override
    public void publish(Content content) {
        redisTemplate.convertAndSend(topic.getTopic(), content);
    }

}
