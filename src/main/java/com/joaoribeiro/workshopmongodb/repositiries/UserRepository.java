package com.joaoribeiro.workshopmongodb.repositiries;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.joaoribeiro.workshopmongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

}
