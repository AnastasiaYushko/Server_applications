package org.example.handler.studentGroup;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.GroupController;
import org.springframework.stereotype.Component;

@Component
public class GetStudentGroupsHandler implements IHandler {
    @Override
    public String handler(Object str) throws JsonProcessingException {

        ResponseEntity<?> getStudentGroupsResponse = GroupController.getStudentGroups();

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(getStudentGroupsResponse);
    }
}
