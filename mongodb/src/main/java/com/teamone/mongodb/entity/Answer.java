package com.teamone.mongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Answer {

	private int answerId;
	private int questionId;
	private String description;
	private int votes;
	private int userID;
	private String modifiedAt;
	private boolean isBest;
}
