package com.test.java_notes_controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.test.java_notes_bean.Topic;
import com.test.java_notes_bean.TopicExtendContent;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/javaContent")
public class JavaNotesController {

	@Autowired
	JavaNotesDao javaNotesDao;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/saveContent", method = RequestMethod.POST)
	public String save(@RequestBody TopicExtendContent topic) {
		topic.setCreatedOn(new Date());
		topic.setUpdatedOn(new Date());
		topic.setStatus(1);
		javaNotesDao.save(topic);
		return "list";
	}

	@RequestMapping(value = "/getContent/{id}", method = RequestMethod.GET, produces = "application/json")
//	@JsonProperty("Employee")
	public TopicExtendContent findById(@PathVariable int id, Model m) {
		TopicExtendContent topic = javaNotesDao.findById(id);
		m.addAttribute("topic", topic);
		return topic;
	}

	@RequestMapping(value = "/getAllContent", method = RequestMethod.GET)
//	@JsonProperty("Topic")
	public List<TopicExtendContent> findAll(Model m) {
		List<TopicExtendContent> list = javaNotesDao.findAll();
		m.addAttribute("list", list);
		return list;
	}

}
