package org.example.handler.subject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.subject.get.GetSubjectByIdRequest;
import org.example.dto_response.subject.GetSubjectByIdResponse;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.SubjectController;

public class GetSubjectByIdHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        GetSubjectByIdRequest getSubjectByIdRequest = objectMapper.readValue(jsonRequest, GetSubjectByIdRequest.class);

        ResponseEntity<GetSubjectByIdResponse> getSubjectResponse = SubjectController.getSubjectById(getSubjectByIdRequest);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(getSubjectResponse);
    }
}
