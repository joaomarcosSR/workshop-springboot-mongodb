package com.joaoribeiro.workshopmongodb.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.joaoribeiro.workshopmongodb.domain.User;
import com.joaoribeiro.workshopmongodb.dto.UserDTO;
import com.joaoribeiro.workshopmongodb.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
		return ResponseEntity.ok(listDTO);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User obj = service.findById(id);
		return ResponseEntity.ok(new UserDTO(obj));
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> insert(@RequestBody UserDTO objDto){
		User obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(new UserDTO(obj));
	}
	
//	@DeleteMapping(value = "/{id}")
//	public ResponseEntity<Void> delete (@PathVariable Long id){
//		service.delete(id);
//		return ResponseEntity.noContent().build();
//	}
//	
//	@PutMapping(value = "/{id}")
//	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
//		obj = service.update(id, obj);
//		return ResponseEntity.ok(obj);
//	}
}
