package com.joaoribeiro.workshopmongodb.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.joaoribeiro.workshopmongodb.domain.Post;
import com.joaoribeiro.workshopmongodb.domain.User;
import com.joaoribeiro.workshopmongodb.repositiries.PostRepository;
import com.joaoribeiro.workshopmongodb.repositiries.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null,Instant.parse("2018-03-21T19:53:07Z"),"Partiu viagem","Vou viajar para São Paulo. Abraços!",maria);
		Post post2 = new Post(null,Instant.parse("2018-03-21T19:53:07Z"),"Bom dia","Acordei feliz hoje!",maria);
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		postRepository.saveAll(Arrays.asList(post1,post2));
	}

}
