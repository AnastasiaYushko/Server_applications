package org.example.handler.subject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.subject.delete.DeleteSubjectRequest;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.SubjectController;

public class DeleteSubjectHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        DeleteSubjectRequest deleteSubjectRequest = objectMapper.readValue(jsonRequest, DeleteSubjectRequest.class);

        ResponseEntity<String> deleteSubjectResponse = SubjectController.deleteSubject(deleteSubjectRequest);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(deleteSubjectResponse);
    }
}
