package com.data.content.subscriber.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Content")
public class Content {
    @Id
    private String id;
    private  String content;
    @Indexed
    private Date timestamp;
    @JsonProperty("longest_palindrome_size")
    private int palindromeSize;
}
