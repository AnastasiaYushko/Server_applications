package org.example.handler.teacher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.teacher.delete.DeleteTeacherRequest;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.TeacherController;

public class DeleteTeacherHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        DeleteTeacherRequest deleteTeacherRequest = objectMapper.readValue(jsonRequest, DeleteTeacherRequest.class);

        ResponseEntity<String> deleteTeacherResponse = TeacherController.deleteTeacher(deleteTeacherRequest);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(deleteTeacherResponse);
    }
}
