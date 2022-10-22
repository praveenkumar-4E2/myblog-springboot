package com.myblog.dto;

import java.util.List;

import com.myblog.model.Subject;
import com.myblog.model.Topic;

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
public class TopicDto {
	private Long topicId;
	private String topicName;

}
