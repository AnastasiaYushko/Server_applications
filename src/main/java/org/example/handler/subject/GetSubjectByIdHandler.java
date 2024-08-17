/*
package org.example.handler.subject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.dtoRequest.subject.GetSubjectByIdRequest;
import org.example.handler.IHandler;
import org.example.ResponseEntity;
import org.example.networkOperations.controllers.SubjectController;
import org.springframework.stereotype.Component;

@Component
public class GetSubjectByIdHandler implements IHandler {
    @Override
    public String handler(Object jsonRequest) throws JsonProcessingException {

        ResponseEntity<?> getSubjectResponse = SubjectController.getSubjectById((GetSubjectByIdRequest) jsonRequest);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(getSubjectResponse);
    }
}
 */
