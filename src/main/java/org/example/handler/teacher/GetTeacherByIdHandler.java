/*
package org.example.handler.teacher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.dtoRequest.teacher.GetTeacherByIdRequest;
import org.example.handler.IHandler;
import org.example.ResponseEntity;
import org.example.networkOperations.controllers.TeacherController;
import org.springframework.stereotype.Component;

@Component
public class GetTeacherByIdHandler implements IHandler {
    @Override
    public String handler(Object jsonRequest) throws JsonProcessingException {

        ResponseEntity<?> getTeacherByIdResponse = TeacherController.getTeacherById((GetTeacherByIdRequest) jsonRequest);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(getTeacherByIdResponse);
    }
}
 */
