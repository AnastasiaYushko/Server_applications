package org.example.handler.student;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.student.get.byGroup.GetStudentsByGroupRequest;
import org.example.dto_response.student.GetStudentsByGroupResponse;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.StudentController;

public class GetStudentsByGroupHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        GetStudentsByGroupRequest getStudentsByGroupRequest = objectMapper.readValue(jsonRequest, GetStudentsByGroupRequest.class);

        ResponseEntity<GetStudentsByGroupResponse> getStudentsByGroupResponse = StudentController.getStudentByGroup(getStudentsByGroupRequest);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(getStudentsByGroupResponse);
    }
}
