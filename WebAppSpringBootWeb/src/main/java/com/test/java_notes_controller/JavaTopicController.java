package com.test.java_notes_controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/javaTopics")
public class JavaTopicController {

	@Autowired
	JavaTopicDao javaTopicDao;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/saveTopic", method = RequestMethod.POST)
	public String save(@RequestBody Topic topic) {
		topic.setCreatedOn(new Date());
		topic.setUpdatedOn(new Date());
		topic.setStatus(1);
		javaTopicDao.save(topic);
		return "list";
	}

	@RequestMapping(value = "/getTopic/{id}", method = RequestMethod.GET, produces = "application/json")
//	@JsonProperty("Employee")
	public Topic findById(@PathVariable int id, Model m) {
		Topic topic = javaTopicDao.findById(id);
		m.addAttribute("topic", topic);
		return topic;
	}

	@RequestMapping(value = "/getAllTopic", method = RequestMethod.GET)
//	@JsonProperty("Topic")
	public List<Topic> findAll(Model m) {
		List<Topic> list = javaTopicDao.findAll();
		m.addAttribute("list", list);
		return list;
	}

}
