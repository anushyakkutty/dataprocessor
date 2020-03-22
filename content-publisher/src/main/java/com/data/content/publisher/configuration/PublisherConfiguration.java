package com.data.content.publisher.configuration;

import com.data.content.publisher.model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@SpringBootConfiguration
@PropertySource("classpath:application.properties")
public class PublisherConfiguration {

    @Autowired
    Environment env;
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(env.getProperty("redis.host"));
        configuration.setPort(Integer.valueOf(env.getProperty("redis.port")));
        return new JedisConnectionFactory(configuration);
    }

    @Bean
    ChannelTopic topic() {
        return new ChannelTopic("content-topic");
    }

    @Bean
    public RedisTemplate<?, ?> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<byte[], byte[]> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory);
        template.setValueSerializer(new Jackson2JsonRedisSerializer(Content.class));
        return template;
    }
}
