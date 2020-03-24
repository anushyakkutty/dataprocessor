package com.data.content.subscriber.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Content")
public class Content {
    @Id
    @JsonIgnore
    private String id;
    private  String content;
    @Indexed
    private String timestamp;
    @JsonProperty("longest_palindrome_size")
    private int palindromeSize;
}
