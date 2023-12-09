package org.example.handler.studentGroup;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.studentGroup.delete.DeleteStudentGroupRequest;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.GroupController;

public class DeleteStudentGroupHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        DeleteStudentGroupRequest deleteStudentGroupRequest = objectMapper.readValue(jsonRequest, DeleteStudentGroupRequest.class);

        ResponseEntity<String> deleteStudentGroupResponse = GroupController.deleteStudentGroup(deleteStudentGroupRequest);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(deleteStudentGroupResponse);
    }
}
