package org.example.handler.student;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.student.get.byId.GetStudentByIdRequest;
import org.example.dto_response.student.GetStudentByIdResponse;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.StudentController;

public class GetStudentByIdHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        GetStudentByIdRequest getStudentByIdRequest = objectMapper.readValue(jsonRequest, GetStudentByIdRequest.class);

        ResponseEntity<GetStudentByIdResponse> getStudentByIdResponse = StudentController.getStudentById(getStudentByIdRequest);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(getStudentByIdResponse);
    }
}
