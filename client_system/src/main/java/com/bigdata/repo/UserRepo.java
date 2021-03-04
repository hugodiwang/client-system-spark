package com.bigdata.repo;

import com.bigdata.jpa.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//define repo interface to regularize insert/drop/select
@Repository("userRepo") // for spring bean
public interface UserRepo extends MongoRepository<User,String> { // by extending we do
  //need to write by ourself

}
