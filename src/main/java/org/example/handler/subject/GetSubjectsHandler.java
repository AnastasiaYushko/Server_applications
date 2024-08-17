/*
package org.example.handler.subject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.dtoResponse.subject.GetSubjectsResponse;
import org.example.handler.IHandler;
import org.example.ResponseEntity;
import org.example.networkOperations.controllers.SubjectController;
import org.springframework.stereotype.Component;

@Component
public class GetSubjectsHandler implements IHandler {
    @Override
    public String handler(Object jsonRequest) throws JsonProcessingException {

        ResponseEntity<GetSubjectsResponse> getSubjectsResponse = SubjectController.getSubjects();

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(getSubjectsResponse);
    }
}
 */
