package com.data.content.subscriber.controller;

import com.data.content.subscriber.model.Content;
import com.data.content.subscriber.service.ContentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ContentController {

    public final ContentService service;

    @RequestMapping(value = "/palindromes", method = RequestMethod.GET)
    public List<Content> fetchPalindromes() {
        return service.get();
    }
}
