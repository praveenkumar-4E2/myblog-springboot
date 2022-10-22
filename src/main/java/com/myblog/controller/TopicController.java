package com.myblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myblog.dto.PageDto;
import com.myblog.dto.TopicDto;
import com.myblog.model.Page;
import com.myblog.model.Subject;
import com.myblog.model.Topic;
import com.myblog.repository.TopicRepository;
import com.myblog.service.TopicService;

@CrossOrigin("http://localhost:4200")
@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@PostMapping("topic")
	public Topic addTopic(@RequestBody Topic topic)
	{
		return topicService.addTopic(topic);
	}
	
	@GetMapping("topic")
	public List<Topic> getTopic()
	{
		return topicService.getTopic();
	}
	
	@GetMapping("topic/list")
	public List<TopicDto> getTopicDto()
	{
		return topicService.getTopicDto();
	}
	
	@GetMapping("topic/page/list/{topicId}")
	public List<Page> getTopicsPagelist(@PathVariable Long topicId) {
		return topicService.getTopicPagelist(topicId);
	}
	
	
	@PutMapping("topic/page/{topicId}")
	public Topic addPageToTopic(@RequestBody Page page,@PathVariable Long topicId)
	{
		return topicService.addPageToTopic(page,topicId);
		
	}
	
	@PutMapping("topic/update/{topicId}")
	public Topic updateTopic(@RequestBody TopicDto topicDto ,@PathVariable Long topicId)
	{
		return topicService.updateTopic(topicDto,topicId);
	}
	
	@DeleteMapping("topic/{topicId}")
	public String deleteTopic(@PathVariable Long topicId) {
		return topicService.deleteTopic(topicId);
	}
}
