package org.example.handler.student;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.network_operations.controllers.StudentController;
import org.example.dto_request.student.EditStudentRequest;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class EditStudentHandler implements IHandler {
    @Override
    public String handler(Object jsonRequest) throws JsonProcessingException {

        ResponseEntity<?> editStudentResponse = StudentController.editStudent((EditStudentRequest) jsonRequest);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(editStudentResponse);
    }
}
