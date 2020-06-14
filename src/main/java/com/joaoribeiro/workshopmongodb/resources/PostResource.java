package com.joaoribeiro.workshopmongodb.resources;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joaoribeiro.workshopmongodb.domain.Post;
import com.joaoribeiro.workshopmongodb.resources.utils.URL;
import com.joaoribeiro.workshopmongodb.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
	
	@GetMapping(value="/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text",defaultValue="") String text){
		text = URL.decodeParam(text);
		List <Post> list = service.findByTitle(text);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value="/fullsearch")
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value="text",defaultValue="") String text,
			@RequestParam(value="minDate",defaultValue="") String minDate,
			@RequestParam(value="maxDate",defaultValue="") String maxDate){
		
		text = URL.decodeParam(text);
		Date dateMin = new Date(0L);
		Instant min = URL.convertDate(minDate, dateMin.toInstant());
		Instant max = URL.convertDate(maxDate, Instant.now());
		
		List <Post> list = service.fullSearch(text, min, max);
		return ResponseEntity.ok(list);
	}
}
