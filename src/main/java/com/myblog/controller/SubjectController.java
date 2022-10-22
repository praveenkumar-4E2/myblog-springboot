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

import com.myblog.dto.SubjectDto;
import com.myblog.dto.TopicDto;
import com.myblog.model.Subject;
import com.myblog.model.Topic;
import com.myblog.model.Subject;
import com.myblog.service.SubjectService;
@CrossOrigin("http://localhost:4200")
@RestController
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	@PostMapping("subject/add")
	public Subject addSubject(@RequestBody Subject subject)
	{
		return subjectService.addSubject(subject);
	}
	@GetMapping("subject")
	public List<Subject> getSubject()
	{
		return subjectService.getSubject();
	}
	
	@GetMapping("subject/{subjectId}")
	public Subject getSubjectById(@PathVariable Long subjectId)
	{
		return subjectService.getSubjectById(subjectId);
	}
	
	//to get topic subjectdto
	@GetMapping("subject/topic/list/{subjectId}")
	public List<TopicDto> getSubjectTopiclist(@PathVariable Long subjectId) {
		return subjectService.getSubjecTopiclist(subjectId);
	}
	
	@PutMapping("subject/update/{subjectId}")
	public Subject updateSubject(@RequestBody SubjectDto subject,@PathVariable Long subjectId)
	{
		return subjectService.upateSubject(subject,subjectId);
	}
	
	//to add topic to subject
	@PutMapping("subject/topic/{subjectId}")
	public Subject  addTopicToSubject(@RequestBody Topic topic,@PathVariable Long subjectId)
	{
		return subjectService.addTopicToSubject(topic,subjectId);
	}
	
	@DeleteMapping("subject/{subjectId}")
	public String deleteSubject(@PathVariable Long subjectId) {
		return subjectService.deleteSubject(subjectId);
	}
}
