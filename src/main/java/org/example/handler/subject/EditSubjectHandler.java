package org.example.handler.subject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.subject.edit.EditSubjectRequest;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.SubjectController;

public class EditSubjectHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        EditSubjectRequest editSubjectRequest = objectMapper.readValue(jsonRequest, EditSubjectRequest.class);

        ResponseEntity<String> editSubjectResponse = SubjectController.editSubject(editSubjectRequest);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(editSubjectResponse);
    }
}
