package com.data.content.subscriber.repository;

import com.data.content.subscriber.model.Content;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository  extends CrudRepository<Content, String> {
}
