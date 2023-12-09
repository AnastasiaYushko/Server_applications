package org.example.handler.studentGroup;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.studentGroup.get.GetStudentGroupByIdRequest;
import org.example.dto_response.studentGroup.GetStudentGroupByIdResponse;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.GroupController;

public class GetStudentGroupByIdHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        GetStudentGroupByIdRequest getStudentGroupByIdRequest = objectMapper.readValue(jsonRequest, GetStudentGroupByIdRequest.class);

        ResponseEntity<GetStudentGroupByIdResponse> getStudentGroupByIdResponse = GroupController.getStudentGroupById(getStudentGroupByIdRequest);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(getStudentGroupByIdResponse);
    }
}
