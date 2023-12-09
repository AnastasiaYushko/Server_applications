package org.example.handler.teacher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.teacher.add.AddTeacherRequest;
import org.example.dto_response.teacher.AddTeacherResponse;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.TeacherController;

public class AddTeacherHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        AddTeacherRequest addTeacherRequest = objectMapper.readValue(jsonRequest, AddTeacherRequest.class);

        ResponseEntity<AddTeacherResponse> addTeacherResponse = TeacherController.addTeacher(addTeacherRequest);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(addTeacherResponse);
    }
}
