package com.myblog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString


public class SubjectDto {
	private Long subjectId;
	private String subjectName;
	private String subjectImage;
	private String description;
	private String preRequests ;
	private String audience;


}
