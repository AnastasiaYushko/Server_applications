package org.example.handler.subject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_response.subject.GetSubjectsResponse;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.SubjectController;

public class GetSubjectsHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws JsonProcessingException {

        ResponseEntity<GetSubjectsResponse> getSubjectsResponse = SubjectController.getSubjects();

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(getSubjectsResponse);
    }
}
