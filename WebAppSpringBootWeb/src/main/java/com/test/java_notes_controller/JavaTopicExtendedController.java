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
import com.test.java_notes_bean.TopicExtends;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/javaTopicExtended")
public class JavaTopicExtendedController {
//	http://localhost:9090/javaTopicExtended/getAllTopicsExtended/
	@Autowired
	JavaTopicExtendedDao javaTopicExtendedDao;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/saveTopicExtended", method = RequestMethod.POST)
	public String saveTopicsExtended(@RequestBody TopicExtends topic) {
		topic.setCreatedOn(new Date());
		topic.setUpdatedOn(new Date());
		topic.setStatus(1);
		javaTopicExtendedDao.save(topic);
		return "list";
	}

	@RequestMapping(value = "/getTopicExtended/{id}", method = RequestMethod.GET, produces = "application/json")
//	@JsonProperty("Employee")
	public TopicExtends findTopicsExtendedById(@PathVariable int id, Model m) {
		TopicExtends topic = javaTopicExtendedDao.findById(id);
		m.addAttribute("topic", topic);
		return topic;
	}

	@RequestMapping(value = "/getAllTopicsExtended", method = RequestMethod.GET)
//	@JsonProperty("Topic")
	public List<TopicExtends> findTopicsExtendedAll(Model m) {
		List<TopicExtends> list = javaTopicExtendedDao.findAll();
		m.addAttribute("list", list);
		return list;
	}

}
