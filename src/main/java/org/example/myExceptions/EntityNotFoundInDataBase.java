package org.example.myExceptions;

public class EntityNotFoundInDataBase extends Exception {
    public EntityNotFoundInDataBase(String message){
        super(message);
    }
}
