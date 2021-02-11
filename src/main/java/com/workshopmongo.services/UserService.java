package com.workshopmongo;

import com.workshopmongo.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.mongodb.core.aggregation.MergeOperation.UniqueMergeId.id;
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

    //Method that insert a nre User 
    public User insert(User obj) {
        return repo.insert(obj);
    }

    //Method that delete a User 
    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }

    //Method that update a User 
    public User update(User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }
    
    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    //Method that get a DTO and instantiation a user
    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
    
}
