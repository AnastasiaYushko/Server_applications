package org.example.handler.teacher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.teacher.get.GetTeacherByIdRequest;
import org.example.dto_response.teacher.GetTeacherByIdResponse;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.TeacherController;

public class GetTeacherByIdHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        GetTeacherByIdRequest getTeacherByIdRequest = objectMapper.readValue(jsonRequest, GetTeacherByIdRequest.class);

        ResponseEntity<GetTeacherByIdResponse> getTeacherByIdResponse = TeacherController.getTeacherById(getTeacherByIdRequest);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(getTeacherByIdResponse);
    }
}
