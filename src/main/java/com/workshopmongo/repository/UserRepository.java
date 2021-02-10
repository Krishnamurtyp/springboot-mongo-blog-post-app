
package com.workshopmongo.repository;

import com.workshopmongo.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jonas created 04/02/2021
 */

//Anotacao springBoot 
@Repository
public interface UserRepository extends MongoRepository<User, String>{
   
    
}
