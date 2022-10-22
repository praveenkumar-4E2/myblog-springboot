package com.myblog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myblog.dto.PageDto;
import com.myblog.dto.TopicDto;
import com.myblog.model.Page;
import com.myblog.model.Subject;
import com.myblog.model.Topic;
import com.myblog.repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	public Topic addTopic(Topic topic) {
		// TODO Auto-generated method stub
		return topicRepository.save(topic);
	}

	public List<Topic> getTopic() {
		// TODO Auto-generated method stub
		return topicRepository.findAll();
	}

	public Topic addPageToTopic(Page page, Long topicId) {

		Topic existingTopic=topicRepository.getById(topicId);
		List<Page> existingPages=existingTopic.getPages();
		existingPages.add(page);
		existingTopic.setPages(existingPages);
		return topicRepository.save(existingTopic);
	}

	public String deleteTopic(Long topicId) {
		// TODO Auto-generated method stub
		topicRepository.deleteById(topicId);
		return "topic is deleted";
	}

	public List<TopicDto> getTopicDto() {
		// TODO Auto-generated method stub
		List<Topic> topics=getTopic();
		ArrayList<TopicDto > list=new ArrayList<TopicDto>();
		topics.forEach(data->list.add(new TopicDto(data.getTopicId(),data.getTopicName())));
		return list;
		}

	public List<Page> getTopicPagelist(Long topicId) {
		// TODO Auto-generated method stub
		Topic topic=topicRepository.getReferenceById(topicId);
		List<Page> pages=topic.getPages();
		
		return pages;
	}

	public Topic updateTopic(TopicDto topicDto, Long topicId) {
		// TODO Auto-generated method stub
		Topic updatedTopic=topicRepository.getById(topicId);
		updatedTopic.setTopicName(topicDto.getTopicName());
		return topicRepository.save(updatedTopic);
	}
}
