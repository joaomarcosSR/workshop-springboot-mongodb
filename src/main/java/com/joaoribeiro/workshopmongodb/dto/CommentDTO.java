package com.joaoribeiro.workshopmongodb.dto;

import java.io.Serializable;
import java.time.Instant;

public class CommentDTO implements Serializable {

	private String id;
	private Instant date;
	private AuthorDTO author;

	public CommentDTO() {
	}

	public CommentDTO(String id, Instant date, AuthorDTO author) {
		super();
		this.id = id;
		this.date = date;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

}
