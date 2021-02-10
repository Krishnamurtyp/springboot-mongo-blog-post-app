package com.workshopmongo;

/**
 *
 * @author Jonas created 08/02/2021
 */
public class ObjectNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    //OVERLAPPINGGET THE CONSTRUCTOR THAT GET STRING LIKE ARGUMENT
    public ObjectNotFoundException(String msg) {
        super(msg);
    }
}
