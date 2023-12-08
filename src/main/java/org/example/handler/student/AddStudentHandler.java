package org.example.handler.student;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.student.add.AddStudentRequest;
import org.example.dto_response.student.AddStudentResponse;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.StudentController;

public class AddStudentHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        AddStudentRequest addStudentRequest = objectMapper.readValue(jsonRequest, AddStudentRequest.class);

        ResponseEntity<AddStudentResponse> addStudentResponse = StudentController.addStudent(addStudentRequest);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(addStudentResponse);
    }
}
