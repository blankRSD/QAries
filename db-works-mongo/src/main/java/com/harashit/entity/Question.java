package com.harashit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Question {

	private int questionId;
	private String title;
	private String description;
	private int votes;
	private String modifiedAt;
	private int userId;
}
