/*
package org.example.handler.studentGroup;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.dtoRequest.studentGroup.GetStudentGroupByIdRequest;
import org.example.handler.IHandler;
import org.example.ResponseEntity;
import org.example.networkOperations.controllers.GroupController;
import org.springframework.stereotype.Component;

@Component
public class GetStudentGroupByIdHandler implements IHandler {
    @Override
    public String handler(Object jsonRequest) throws JsonProcessingException {

        ResponseEntity<?> getStudentGroupByIdResponse = GroupController.getStudentGroupById((GetStudentGroupByIdRequest) jsonRequest);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(getStudentGroupByIdResponse);
    }
}
 */
