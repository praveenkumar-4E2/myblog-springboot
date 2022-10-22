package com.myblog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myblog.dto.SubjectDto;
import com.myblog.dto.TopicDto;
import com.myblog.model.Category;
import com.myblog.model.Subject;
import com.myblog.model.Topic;
import com.myblog.repository.subjectRepository;

@Service
public class SubjectService {

	@Autowired
	private subjectRepository subjectRepository;

	public Subject addSubject(Subject subject) {
		// TODO Auto-generated method stub
		return subjectRepository.save(subject);
	}

	public List<Subject> getSubject() {
		// TODO Auto-generated method stub
		return subjectRepository.findAll();
	}

	public Subject addTopicToSubject(Topic topic, Long subjectId) {
		// TODO Auto-generated method stub
		Subject exisitingSubject=subjectRepository.getById(subjectId);
		List<Topic> existingTopics=exisitingSubject.getTopic();
		existingTopics.add(topic);
		exisitingSubject.setTopic(existingTopics);
		return subjectRepository.save(exisitingSubject);
	}

	public String deleteSubject(Long subjectId) {

		subjectRepository.deleteById(subjectId);
		return "subject is deleted";
	}

	

	public List<TopicDto> getSubjecTopiclist(Long subjectId) {
		Subject subject=subjectRepository.getById(subjectId);
		List<Topic> subjects=subject.getTopic();
		ArrayList<TopicDto> topicDtos=new ArrayList<TopicDto>();
		subjects.forEach(data->topicDtos.add(new TopicDto(data.getTopicId(),data.getTopicName())));
		return topicDtos;
	}

	public Subject upateSubject(SubjectDto subjectDto, Long subjectId) {
		// TODO Auto-generated method stub
		Subject updatedSubject=subjectRepository.getById(subjectId);
		updatedSubject.setSubjectName(subjectDto.getSubjectName());
		updatedSubject.setSubjectImage(subjectDto.getSubjectImage());
		updatedSubject.setDescription(subjectDto.getDescription());
		updatedSubject.setPreRequests(subjectDto.getPreRequests());
		updatedSubject.setAudience(subjectDto.getAudience());
		return subjectRepository.save(updatedSubject);
	}

	public Subject getSubjectById(Long subjectId) {
		
		return subjectRepository.getById(subjectId);
	}
}
