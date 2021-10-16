package com.test.java_notes_controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.test.java_notes_bean.Topic;
import com.test.java_notes_bean.TopicExtends;


@Service
public interface JavaTopicExtendedService extends CrudRepository<TopicExtends, Integer> {

}
