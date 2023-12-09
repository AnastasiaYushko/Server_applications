package org.example.handler.student;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.student.delete.DeleteStudentRequest;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.StudentController;

public class DeleteStudentHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        DeleteStudentRequest deleteStudentRequest = objectMapper.readValue(jsonRequest, DeleteStudentRequest.class);

        ResponseEntity<String> deleteStudentResponse = StudentController.deleteStudent(deleteStudentRequest);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(deleteStudentResponse);
    }
}
