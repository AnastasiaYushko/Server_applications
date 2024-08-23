package org.example.handlers;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.example.myExceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    // (@Valid @RequestBody AddLessonRequest jsonRequest)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions_1(MethodArgumentNotValidException ex) {
        HashMap<String, String> result = new HashMap<>();
        List<ObjectError> errors = ex.getBindingResult().getAllErrors();

        for (ObjectError error : errors) {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            result.put(fieldName, errorMessage);
        }
        return new ResponseEntity<>(result, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    // Например id = абвг
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<HashMap<String, String>> handleValidationExceptions_2(MethodArgumentTypeMismatchException ex) {
        HashMap<String, String> errors = new HashMap<>();
        String error = " тип параметра неверен";
        errors.put(ex.getName(), error);
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AddEntityMatchData.class)
    public ResponseEntity<String> handleValidationExceptions_3(AddEntityMatchData ex) {
        String error = "Такой объект уже есть в базе данных";
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StupidChanges.class)
    public ResponseEntity<String> handleValidationExceptions_4(StupidChanges ex) {
        String error = "Новые данные, которые вы хотите внести, сопадают с имеющимися у этого объекта";
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ChangesEntityLeadToConflict.class)
    public ResponseEntity<String> handleValidationExceptions_5(ChangesEntityLeadToConflict ex) {
        String error = "Изменения совпадают с другим объектом в базе данных";
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    //(@Valid @RequestParam("id") @Positive int id)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions_6(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            String fieldName = violation.getPropertyPath().toString();
            String errorMessage = violation.getMessage();
            errors.put(fieldName, errorMessage);
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundInDataBase.class)
    public ResponseEntity<String> handleValidationExceptions_7(EntityNotFoundInDataBase ex) {
        String error = "Объект класса " + ex.getClassError() + " не найден в базе данных";
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // например при edit LessonVisiting
    // Там привязка LessonId к LessonVisitingId, а при запросе передаются оба ID
    // Либо добавление студентов с неверными данными
    @ExceptionHandler(ConflictingData.class)
    public ResponseEntity<String> handleValidationExceptions_8(ConflictingData ex){
        String error = "В запросе переданы противоречивые данные : " + ex.getMessage();
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleValidationExceptions_9(IllegalArgumentException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }
}