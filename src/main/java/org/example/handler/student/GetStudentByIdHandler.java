/*
package org.example.handler.student;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.networkOperations.controllers.StudentController;
import org.example.dtoRequest.student.GetStudentByIdRequest;
import org.example.handler.IHandler;
import org.example.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class GetStudentByIdHandler implements IHandler {
    @Override
    public String handler(Object jsonRequest) throws JsonProcessingException {

        ResponseEntity<?> getStudentByIdResponse = StudentController.getStudentById((GetStudentByIdRequest) jsonRequest);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(getStudentByIdResponse);
    }
}
 */
