/*
package org.example.handler.student;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.networkOperations.controllers.StudentController;
import org.example.dtoRequest.student.AddStudentRequest;
import org.example.handler.IHandler;
import org.example.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class AddStudentHandler implements IHandler {
    @Override
    public String handler(Object jsonRequest) throws JsonProcessingException {

        ResponseEntity<?> addStudentResponse = StudentController.addStudent((AddStudentRequest) jsonRequest);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(addStudentResponse);
    }
}
 */
