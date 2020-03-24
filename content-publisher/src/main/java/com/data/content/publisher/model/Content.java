package com.data.content.publisher.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.redis.core.RedisHash;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Content")
@ApiModel("Model that represents a content")
public class Content {
    @NonNull
    @NotBlank
    @ApiModelProperty(value = "The content String", position = 0, required=true)
    private  String content;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ssZ")
    @ApiModelProperty(value = "The timestamp", position = 1, required=true)
    private Date timestamp;
}
