package com.bigdata.repo;

import com.bigdata.jpa.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//define repo interface to regularize insert/drop/select
@Repository("personRepo") // for spring bean
public interface PersonRepo extends MongoRepository<User,String>, PersonRepoTemp { // by extending we do
  //need to write by ourself

}
