package org.example.handler.studentGroup;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.dto_request.studentGroup.AddStudentGroupRequest;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.GroupController;
import org.springframework.stereotype.Component;

@Component
public class AddStudentGroupHandler implements IHandler {
    @Override
    public String handler(Object jsonRequest) throws JsonProcessingException {

        ResponseEntity<?> addStudentGroupResponse = GroupController.addStudentGroup((AddStudentGroupRequest) jsonRequest);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(addStudentGroupResponse);
    }
}
