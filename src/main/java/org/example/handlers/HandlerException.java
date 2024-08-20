package org.example.handlers;

import org.example.ResponseEntity;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class HandlerException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions_ArgumentNotValid(MethodArgumentNotValidException ex) {
        HashMap<String, String> result = new HashMap<>();
        List<ObjectError> errors = ex.getBindingResult().getAllErrors();

        for (ObjectError error : errors) {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            result.put(fieldName, errorMessage);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<HashMap<String, String>> handleValidationExceptions_(MethodArgumentTypeMismatchException ex) {
        HashMap<String, String> errors = new HashMap<>();
        String error = " тип параметра неверен";
        errors.put(ex.getName(), error);
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AddEntityMatchData.class)
    public ResponseEntity<String> handleValidationExceptions_(AddEntityMatchData ex) {
        String error = "Такой объект уже есть в базе данных";
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StupidChanges.class)
    public ResponseEntity<String> handleValidationExceptions_(StupidChanges ex) {
        String error = "Новые данные, которые вы хотите внести, сопадают с имеющимися у этого объекта";
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ChangesEntityLeadToConflict.class)
    public ResponseEntity<String> handleValidationExceptions_(ChangesEntityLeadToConflict ex) {
        String error = "Изменения совпадают с другим объектом в базе данных";
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundInDataBase.class)
    public ResponseEntity<String> handleValidationExceptions_(EntityNotFoundInDataBase ex) {
        String error = "Объект класса " + ex.getClassError() + " не найден в базе данных";
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}