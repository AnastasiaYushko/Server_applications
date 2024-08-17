package org.example.handler.lesson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.dto_request.lesson.DeleteLessonsByGroupRequest;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.LessonController;
import org.springframework.stereotype.Component;

@Component
public class DeleteLessonsByGroupHandler implements IHandler {
    @Override
    public String handler(Object jsonRequest) throws JsonProcessingException {

        ResponseEntity<?> deleteLessonResponse = LessonController.deleteLessonsByGroup((DeleteLessonsByGroupRequest) jsonRequest);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(deleteLessonResponse);
    }
}
