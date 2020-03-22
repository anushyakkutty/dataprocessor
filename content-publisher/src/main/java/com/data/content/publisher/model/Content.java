package com.data.content.publisher.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.redis.core.RedisHash;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Content")
public class Content {
    @NonNull
    @NotBlank
    private  String content;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ssZ")
    private Date timestamp;
}
