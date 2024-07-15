package org.example.handler.student;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.dto_request.student.get.byId.GetStudentByIdRequest;
import org.example.dto_response.student.GetStudentByIdResponse;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.StudentController;
import org.springframework.stereotype.Component;

@Component
public class GetStudentByIdHandler implements IHandler {
    @Override
    public String handler(Object jsonRequest) throws JsonProcessingException {

        ResponseEntity<GetStudentByIdResponse> getStudentByIdResponse = StudentController.getStudentById((GetStudentByIdRequest) jsonRequest);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(getStudentByIdResponse);
    }
}
