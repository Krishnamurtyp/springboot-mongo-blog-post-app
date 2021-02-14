package com.workshopmongo.repository;

import com.workshopmongo.Post;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jonas created 11/02/2021
 */
//Anotacao springBoot 
@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    //Query method, to created automatic queries
    List<Post> findByTitleContainingIgnoreCase(String text);
    
}
