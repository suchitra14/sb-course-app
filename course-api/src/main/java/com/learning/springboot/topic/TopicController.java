package com.learning.springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	

	@Autowired
	private TopicService topicService;
	
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics(){
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}

	@RequestMapping(value = "/topics", method = RequestMethod.POST)
	public void addTopic(@RequestBody Topic t) {
		topicService.addTopic(t);
	}
	
	@RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
	public void updateTopic(@RequestBody Topic t, @PathVariable String id) {
		topicService.updateTopic(id, t);
	}
	
	@RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
	public void deleteTopic(@PathVariable String id) {
		topicService.removeTopic(id);
	}

	
}
