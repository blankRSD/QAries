package com.teamone.mongodb.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
	private long questionId;
	private int userId;
	private String title;
	private String description;
	private int votes;
	private Date modifiedAt;
}
