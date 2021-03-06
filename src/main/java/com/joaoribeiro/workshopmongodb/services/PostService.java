package com.joaoribeiro.workshopmongodb.services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaoribeiro.workshopmongodb.domain.Post;
import com.joaoribeiro.workshopmongodb.repositiries.PostRepository;
import com.joaoribeiro.workshopmongodb.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found. Id " + id));
	}
	
	public List<Post> findByTitle(String text){
		return repository.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Instant minDate, Instant maxDate){
		return repository.fullSearch(text, minDate, maxDate.plus(1,ChronoUnit.DAYS));
	}

}
