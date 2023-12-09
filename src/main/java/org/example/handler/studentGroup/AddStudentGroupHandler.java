package org.example.handler.studentGroup;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.studentGroup.add.AddStudentGroupRequest;
import org.example.dto_response.studentGroup.AddStudentGroupResponse;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.GroupController;

public class AddStudentGroupHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        AddStudentGroupRequest addStudentGroupRequest = objectMapper.readValue(jsonRequest, AddStudentGroupRequest.class);

        ResponseEntity<AddStudentGroupResponse> addStudentGroupResponse = GroupController.addStudentGroup(addStudentGroupRequest);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(addStudentGroupResponse);
    }
}
