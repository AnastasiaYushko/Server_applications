package org.example.myExceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConflictingData extends Exception{
    public ConflictingData(String message){
        super(message);
    }
}
