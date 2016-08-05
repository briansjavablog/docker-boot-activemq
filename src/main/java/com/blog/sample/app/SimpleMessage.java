package com.blog.sample.app;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SimpleMessage {

	private final String message;
	private final Date creationTime;
}