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

import com.myblog.model.Page;
import com.myblog.model.Page;
import com.myblog.service.PageSerivce;
@CrossOrigin("http://localhost:4200")
@RestController
public class PageController {

	@Autowired
	private PageSerivce pageSerivce;
	
	
	
	
	
	
	@GetMapping("page/{pageId}")
	public Page getPage(@PathVariable Long pageId )
	{
		return pageSerivce.getPage(pageId);
	}
	
	@PutMapping("page/{pageId}")
	public Page updatePage(@RequestBody Page page,@PathVariable Long pageId)
	{
		return pageSerivce.updatePage(page,pageId);
	}
	
	@DeleteMapping("page/{pageId}")
	public String deletePage(@PathVariable Long pageId) {
		return pageSerivce.deleteCategory(pageId);
	}
}
