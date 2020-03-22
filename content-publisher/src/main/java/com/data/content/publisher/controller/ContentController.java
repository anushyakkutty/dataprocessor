package com.data.content.publisher.controller;

import com.data.content.publisher.model.Content;
import com.data.content.publisher.service.ContentPublisherService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ContentController {

    public final ContentPublisherService service;

    @RequestMapping(value = "/content", method = RequestMethod.POST)
    public void createContent(@Valid  @RequestBody Content content) {
        service.publish(content);
    }
}
