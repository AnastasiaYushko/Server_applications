package org.example.handler.studentGroup;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.studentGroup.edit.EditStudentGroupRequest;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.GroupController;

public class EditStudentGroupHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        EditStudentGroupRequest editStudentGroupRequest = objectMapper.readValue(jsonRequest, EditStudentGroupRequest.class);

        ResponseEntity<String> editStudentGroupResponse = GroupController.editStudentGroup(editStudentGroupRequest);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(editStudentGroupResponse);
    }
}
