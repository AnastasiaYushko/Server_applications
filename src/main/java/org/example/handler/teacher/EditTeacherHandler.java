package org.example.handler.teacher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.dto_request.teacher.edit.EditTeacherRequest;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.TeacherController;
import org.springframework.stereotype.Component;

@Component
public class EditTeacherHandler implements IHandler {
    @Override
    public String handler(Object jsonRequest) throws JsonProcessingException {

        ResponseEntity<?> editTeacherResponse = TeacherController.editTeacher((EditTeacherRequest) jsonRequest);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(editTeacherResponse);
    }
}
