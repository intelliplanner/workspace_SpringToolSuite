package com.test.java_notes_controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.java_notes_bean.Topic;

@Repository
public class JavaTopicDao {

	@Autowired
	JavaTopicService javaTopicService;

	public void save(Topic topic) {
		javaTopicService.save(topic);
	}

	public void update(Topic topic) {
		javaTopicService.save(topic);
	}

	public void delete(int id) {
		javaTopicService.deleteById(id);
	}

	public Topic findById(int id) {
		Topic  topic = javaTopicService.findById(id).get();
		return topic;
	}

	public List<Topic> findAll() {
		List<Topic> topic = new ArrayList<Topic>();
		javaTopicService.findAll().forEach(topic::add);
		return topic;
	}
}
