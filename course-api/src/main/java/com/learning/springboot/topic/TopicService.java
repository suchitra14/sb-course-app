package com.learning.springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("java", "Java", "Java desc"),
			new Topic("javascript", "Javascript", "Javascript desc"),
			new Topic("angular", "Angular", "Angular desc")));
	
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	
	public Topic getTopic(String id) {
		return topics.stream()
				.filter(t -> t.getId().equals(id))
				.findFirst().get();
	}
	
	
	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	
	
	public void updateTopic(String id, Topic t) {
		for(int i =0; i < topics.size(); i++) {
			if(topics.get(i).getId().equals(t.getId())) {
				topics.set(i, t);
				
			}
		}
	}
	
	public void removeTopic(String id) {
		Topic topic = topics.stream().filter(tpc -> tpc.getId().equals(id)).findFirst().get();
		topics.remove(topic);
	}
	
}
