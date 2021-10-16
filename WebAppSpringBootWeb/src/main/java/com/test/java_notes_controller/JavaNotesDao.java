package com.test.java_notes_controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.java_notes_bean.Topic;
import com.test.java_notes_bean.TopicExtendContent;

@Repository
public class JavaNotesDao {

	@Autowired
	JavaNotesService javaNotesService;

	public void save(TopicExtendContent topic) {
		javaNotesService.save(topic);
	}

	public void update(TopicExtendContent topic) {
		javaNotesService.save(topic);
	}

	public void delete(int id) {
		javaNotesService.deleteById(id);
	}

	public TopicExtendContent findById(int id) {
		TopicExtendContent  topic = javaNotesService.findById(id).get();
		return topic;
	}

	public List<TopicExtendContent> findAll() {
		List<TopicExtendContent> topic = new ArrayList<TopicExtendContent>();
		javaNotesService.findAll().forEach(topic::add);
		return topic;
	}
}
