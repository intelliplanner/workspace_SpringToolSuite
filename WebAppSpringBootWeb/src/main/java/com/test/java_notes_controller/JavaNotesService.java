package com.test.java_notes_controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.test.java_notes_bean.Topic;
import com.test.java_notes_bean.TopicExtendContent;


@Service
public interface JavaNotesService extends CrudRepository<TopicExtendContent, Integer> {

}
