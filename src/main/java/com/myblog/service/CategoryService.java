package com.myblog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myblog.dto.CategoryDto;
import com.myblog.dto.CategorySubjectDto;
import com.myblog.dto.SubjectDto;
import com.myblog.model.Category;
import com.myblog.model.Page;
import com.myblog.model.Subject;
import com.myblog.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Category addcategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}

	public List<Category> getcategory() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}
	
	
	
	//method to add subject to category

	public Category addSubjectToCategory(Subject subject, Long categoryId) {
		Category existingCategory=categoryRepository.getById(categoryId);
		List<Subject> existingSubjects=existingCategory.getSubject();
		existingSubjects.add(subject);
		existingCategory.setSubject(existingSubjects);
		return categoryRepository.save(existingCategory);
	}

	public String deleteCategory(Long categoryId) {
		// TODO Auto-generated method stub
		categoryRepository.deleteById(categoryId);
		return "category is delelted" ;
	}

	public List<CategoryDto> getCategoryDto() {
		List<CategoryDto> categoryDtos=new ArrayList<>();
		List<Category> exsitingCategories=getcategory();
		
		exsitingCategories.forEach(data->categoryDtos.add(new CategoryDto(data.getCategoryId(),data.getCategoryName())));
		return categoryDtos;
	}

	public List<SubjectDto> getSubjectDto(Long categoryId) {
		Category category=categoryRepository.getById(categoryId);
		List<Subject> subjects=category.getSubject();
		ArrayList<SubjectDto> subjectDtos=new ArrayList<SubjectDto>();
		subjects.forEach(data->subjectDtos.add(new SubjectDto(data.getSubjectId(),data.getSubjectName(),data.getSubjectImage(),data.getDescription(),data.getPreRequests(),data.getAudience())));
		return subjectDtos;
	}
	
	

	public Category updateCategory(Category category,Long categoryId) {
		// TODO Auto-generated method stub
		Category updatedCategory=categoryRepository.getById(categoryId);
		updatedCategory.setCategoryName(category.getCategoryName());
		return categoryRepository.save(updatedCategory);
	}

	public List<CategorySubjectDto> getSubjectDtoList() {
		// TODO Auto-generated method stub
		List<Category> categorylist=categoryRepository.findAll();
		ArrayList<CategorySubjectDto> categorySubjectDtos=new ArrayList<CategorySubjectDto>();
		
		categorylist.forEach(data->categorySubjectDtos.add(new CategorySubjectDto(data.getCategoryId(), data.getCategoryName(),getSubjectDto(data.getCategoryId()))));
				
				
		//categorylist.forEach(data->subjectDtos.add(new SubjectDto(data.getSubjectId(),data.getSubjectName(),data.getSubjectImage(),data.getDescription(),data.getPreRequests(),data.getAudience())));
		
		return categorySubjectDtos;
	}


	
}
