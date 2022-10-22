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
import javax.persistence.Lob;
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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Subject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long subjectId;
	private String subjectName;
	@Lob
	private String subjectImage;
	@Lob
	private String description;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="category_subject_id")	
//
//	private Category category;
	
	@OneToMany(targetEntity = Topic.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "topic_subject_id",referencedColumnName = "subjectId")
	private List<Topic> topic;
	
	private String preRequests ;
	private String audience;
	

}
