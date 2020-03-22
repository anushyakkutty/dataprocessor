package com.data.content.subscriber.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@PropertySource("classpath:application.properties")
@EnableRedisRepositories
@RequiredArgsConstructor
public class RedisSubscriberConfiguration {
    private final Environment env;

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(env.getProperty("redis.host"));
        configuration.setPort(Integer.valueOf(env.getProperty("redis.port")));
        JedisConnectionFactory j = new JedisConnectionFactory(configuration);
        j.getPoolConfig().setMaxIdle(30);
        j.getPoolConfig().setMinIdle(10);
        return j;
    }

    @Bean
    public RedisTemplate<?, ?> redisTemplate() {
        RedisTemplate<byte[], byte[]> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }

    @Bean
    ChannelTopic topic() {
        return new ChannelTopic("content-topic");
    }

    @Autowired
    MessageListener redisMessageSubscriber;

    @Bean
    MessageListenerAdapter messageListener( ) {
        return new MessageListenerAdapter(redisMessageSubscriber);
    }

    @Bean
    RedisMessageListenerContainer redisContainer() {
        RedisMessageListenerContainer container
                = new RedisMessageListenerContainer();
        container.setConnectionFactory(jedisConnectionFactory());
        container.addMessageListener(messageListener(), topic());
        container.setRecoveryInterval(100);
        return container;
    }
}

