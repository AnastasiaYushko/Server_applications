package org.example.handler.teacher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_response.teacher.GetTeachersResponse;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.TeacherController;

public class GetTeachersHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws JsonProcessingException {

        ResponseEntity<GetTeachersResponse> getTeachersResponse = TeacherController.getTeachers();

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(getTeachersResponse);
    }
}
