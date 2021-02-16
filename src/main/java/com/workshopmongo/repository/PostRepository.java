package com.workshopmongo.repository;

import com.workshopmongo.Post;
import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jonas created 11/02/2021
 */
//Anotacao springBoot 
@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    //This anotation enable take with query of MongoDB in the form of text JSON
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);

    //Especial method of Spring to create authomatic query
    List<Post> findByTitleContainingIgnoreCase(String text);

    //Method to created the query
    @Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
