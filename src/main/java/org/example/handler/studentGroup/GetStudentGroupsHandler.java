package org.example.handler.studentGroup;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_response.studentGroup.GetStudentGroupsResponse;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.GroupController;

public class GetStudentGroupsHandler implements IHandler {
    @Override
    public String handler(String str) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        ResponseEntity<GetStudentGroupsResponse> getStudentGroupsResponse= GroupController.getStudentGroups();

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(getStudentGroupsResponse);
    }
}
