package org.example.handler.teacher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.teacher.edit.EditTeacherRequest;
import org.example.dto_response.teacher.EditTeacherResponse;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.TeacherController;

public class EditTeacherHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        EditTeacherRequest editTeacherRequest = objectMapper.readValue(jsonRequest, EditTeacherRequest.class);

        ResponseEntity<EditTeacherResponse> editTeacherResponse = TeacherController.editTeacher(editTeacherRequest);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(editTeacherResponse);
    }
}
