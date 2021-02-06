
package com.workshopmongo;

import com.workshopmongo.repository.UserRepository;
import java.util.List;
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
    public List<User> findAll(){
        return repo.findAll();
}
    
}
