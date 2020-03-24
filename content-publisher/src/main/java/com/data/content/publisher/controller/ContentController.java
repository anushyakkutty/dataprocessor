package com.data.content.publisher.controller;

import com.data.content.publisher.model.Content;
import com.data.content.publisher.service.ContentPublisherService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.servlet.http.HttpServletResponse;


@RestController
@Slf4j
@RequiredArgsConstructor
public class ContentController {

    public final ContentPublisherService service;

    @PostMapping(value = "/content")
    @ApiResponses({
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Invalid content."),
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "Content successfully created.")})
    @ApiOperation(value = "Creates a content and stores it into database.")
    public void createContent(@Valid  @RequestBody  Content content) {
        service.publish(content);
    }
}
