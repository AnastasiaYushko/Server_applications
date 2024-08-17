package org.example.handler.lessonVisiting;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.dto_request.lessonVisiting.AddLessonVisitingRequest;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.LessonVisitingController;
import org.springframework.stereotype.Component;

@Component
public class AddLessonVisitingHandler implements IHandler {
    @Override
    public String handler(Object jsonRequest) throws JsonProcessingException {

        ResponseEntity<?> addStudentVisitingResponse = LessonVisitingController.addLessonVisiting((AddLessonVisitingRequest) jsonRequest);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(addStudentVisitingResponse);
    }
}
