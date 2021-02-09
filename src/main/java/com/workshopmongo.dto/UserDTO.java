/*
Class that have paper of load data of entity in a simple 
way, being possible design only some data of origin entity.
 */
package com.workshopmongo;

import java.io.Serializable;

/**
 *
 * @author Jonas created 08/02/2021
 */
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    //ATTRIBUTES
    private String id;
    private String name;
    private String email;

    //CONSTRUCTOR
    public UserDTO() {
    }

    //CONTRUCTOR INSTANTIATION USER 
    public UserDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
