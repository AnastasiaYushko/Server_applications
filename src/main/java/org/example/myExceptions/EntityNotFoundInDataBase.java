package org.example.myExceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EntityNotFoundInDataBase extends Exception {
    private  String classError;

    public EntityNotFoundInDataBase(String classError) {
        this.classError = classError;
    }
}
