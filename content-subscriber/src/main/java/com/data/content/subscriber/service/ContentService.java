package com.data.content.subscriber.service;

import com.data.content.subscriber.model.Content;
import com.data.content.subscriber.repository.ContentRepository;
import com.data.content.subscriber.utils.PalindromeCalculator;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContentService {
    private final ContentRepository repository;

    public List<Content> get() {
        List<Content> list = new ArrayList<>();
        // Add each element of iterator to the List
        repository.findAll().forEach(e -> {
            e.setPalindromeSize(PalindromeCalculator.sizeOfLongestPalindrome(e.getContent()));
            list.add(e);
        });
        return list;
    }

}
