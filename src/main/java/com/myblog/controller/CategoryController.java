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

import com.myblog.dto.CategoryDto;
import com.myblog.dto.CategorySubjectDto;
import com.myblog.dto.SubjectDto;
import com.myblog.model.Category;
import com.myblog.model.Page;
import com.myblog.model.Subject;
import com.myblog.service.CategoryService;
@CrossOrigin("http://localhost:4200")
@RestController

public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("category/add")
	public Category addCategory(@RequestBody Category category) {
		return categoryService.addcategory(category);
	}

	@GetMapping("category")
	public List<Category> getCategory() {
		return categoryService.getcategory();
	}
	
	//to return only id and name of caregory
	
	@GetMapping("category/list")
	public List<CategoryDto> getCategoryDto() {
		return categoryService.getCategoryDto();
	}
	
	@GetMapping("category/subject/list/{categoryId}")
	public List<SubjectDto> getSubjectDto(@PathVariable Long categoryId) {
		return categoryService.getSubjectDto(categoryId);
	}

	//to return list of category with subject filter
	@GetMapping("category/subject/list")
	public List<CategorySubjectDto> getSubjectDtoList() {
		return categoryService.getSubjectDtoList();
	}
	
	
	// adding subject to category
	@PutMapping("category/addsubject/{categoryId}")
	public Category addSubjectToCategory(@RequestBody Subject subject, @PathVariable Long categoryId) {
		return categoryService.addSubjectToCategory(subject, categoryId);
	}
	
	@PutMapping("category/update/{categoryId}")
	public Category updateCategory(@RequestBody Category category,@PathVariable Long categoryId )
	{
		return categoryService.updateCategory(category,categoryId);
	}

	
	// to delelte category
	@DeleteMapping("category/{categoryId}")
	public String deleteCategory(@PathVariable Long categoryId) {
		return categoryService.deleteCategory(categoryId);
	}

}
