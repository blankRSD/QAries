package com.teamone.mongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Question {

	private String questionId;
	private String title;
	private String description;
	private int votes;
	private String modifiedAt;
	private int userId;
}
