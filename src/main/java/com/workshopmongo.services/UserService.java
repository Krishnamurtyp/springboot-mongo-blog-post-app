package com.workshopmongo;

import com.workshopmongo.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jonas created 04/02/2021
 */
//Classe é im servico e pode ser injetado em outras Classes 
@Service
public class UserService {

    //Injecao automatica do Spring
    @Autowired
    private UserRepository repo;

    //Metodo responsavel para retornar todos os usuarios do banco
    public List<User> findAll() {
        return repo.findAll();
    }

    //Method that found user by ID and handling exception ID incorrect 
    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
