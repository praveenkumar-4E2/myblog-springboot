package com.myblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myblog.model.Page;
import com.myblog.repository.PageRepository;
import com.myblog.repository.TopicRepository;

@Service
public class PageSerivce {

	@Autowired
	private PageRepository pageRepository;

	public Page addPage(Page page) {
		// TODO Auto-generated method stub
		return pageRepository.save(page);
	}

	public List<Page> getPages() {
		// TODO Auto-generated method stub
		return pageRepository.findAll();
	}

	public String deleteCategory(Long pageId) {
		// TODO Auto-generated method stub
		pageRepository.deleteById(pageId);
		return "page is deleted";
	}

	public Page getPage(Long pageId) {
		// TODO Auto-generated method stub
		return pageRepository.getReferenceById(pageId);
	}

	public Page updatePage(Page page, Long pageId) {
		Page updatePage=pageRepository.getById(pageId);
		updatePage.setTitle(page.getTitle());
		updatePage.setContent(page.getContent());
		return pageRepository.save(updatePage);
	}
}
