package com.test.java_notes_controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.test.java_notes_bean.Topic;


@Service
public interface JavaTopicService extends CrudRepository<Topic, Integer> {

}
