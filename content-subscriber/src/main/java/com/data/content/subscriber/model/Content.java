package com.data.content.subscriber.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Content")
@ApiModel("Model that represents a content")
public class Content {
    @Id
    @JsonIgnore
    private String id;
    @ApiModelProperty(value = "The content String", position = 0, required=true)
    private  String content;
    @Indexed
    @ApiModelProperty(value = "The timestamp ", position = 1 , required=true)
    private String timestamp;
    @JsonProperty("longest_palindrome_size")
    @ApiModelProperty(value = "Size of the longest palindrome string that can be constructed from the content.", position = 2)
    private int palindromeSize;
}
