package com.workshopmongo;

import java.io.Serializable;

/**
 *
 * @author Jonas created 11/02/2021
 */
public class AuthorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    //ATTRIBUTES
    private String id;
    private String name;

    //CONSTRUCTOR
    public AuthorDTO() {
    }
    //CONSTRUCTOR
    public AuthorDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
    }
    
    //GET AND SET
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

    
}
