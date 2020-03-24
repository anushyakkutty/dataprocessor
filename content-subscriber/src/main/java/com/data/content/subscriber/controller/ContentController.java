package com.data.content.subscriber.controller;

import com.data.content.subscriber.model.Content;
import com.data.content.subscriber.service.ContentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;


@RestController
@Slf4j
@RequiredArgsConstructor
public class ContentController {

    public final ContentService service;

    @RequestMapping(value = "/content/palindromes", method = RequestMethod.GET)
    @ApiOperation(value = "Fetches the contents from the database.")
    @ApiResponses({
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "Contents returned successfully with the longest palindrome size.")})
    public List<Content> fetchPalindromes() {
        return service.get();
    }
}
