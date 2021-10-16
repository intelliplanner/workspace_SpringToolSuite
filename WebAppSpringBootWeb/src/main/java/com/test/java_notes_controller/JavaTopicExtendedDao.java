package com.test.java_notes_controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.java_notes_bean.Topic;
import com.test.java_notes_bean.TopicExtends;

@Repository
public class JavaTopicExtendedDao {

	@Autowired
	JavaTopicExtendedService javaTopicExtendedService;

	public void save(TopicExtends topic) {
		javaTopicExtendedService.save(topic);
	}

	public void update(TopicExtends topic) {
		javaTopicExtendedService.save(topic);
	}

	public void delete(int id) {
		javaTopicExtendedService.deleteById(id);
	}

	public TopicExtends findById(int id) {
		TopicExtends topic = javaTopicExtendedService.findById(id).get();
		return topic;
	}

	public List<TopicExtends> findAll() {
		List<TopicExtends> topic = new ArrayList<TopicExtends>();
		javaTopicExtendedService.findAll().forEach(topic::add);
		return topic;
	}
}
