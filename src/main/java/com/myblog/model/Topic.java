package com.myblog.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
@ToString
public class Topic implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long topicId;
	private String topicName;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "topic_subject_id")
//	private Subject subject;
	
	@OneToMany(targetEntity = Page.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "topic_page_id",referencedColumnName = "topicId")
	private List<Page> pages;
	
	

}
