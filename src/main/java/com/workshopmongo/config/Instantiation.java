package com.workshopmongo.config;

import com.workshopmongo.Post;
import com.workshopmongo.User;
import com.workshopmongo.repository.PostRepository;
import com.workshopmongo.repository.UserRepository;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Jonas created 05/02/2021
 */
//Class that make the init instantiation of objects
@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    //User repository para fazer conexao com o banco de dados
    private UserRepository userReposiroty;

    @Autowired
    private PostRepository postReposiroty;

    @Override
    public void run(String... arg0) throws Exception {

        //Format of date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userReposiroty.deleteAll(); //clean collection
        postReposiroty.deleteAll(); //clean collection

        //Instantiation User
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        //Instantiation Post with author associated
        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abracos", maria);
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje", maria);

        userReposiroty.saveAll(Arrays.asList(maria, alex, bob));
	postReposiroty.saveAll(Arrays.asList(post1, post2));

    }

}
