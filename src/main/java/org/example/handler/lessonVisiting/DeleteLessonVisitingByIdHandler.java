/*
package org.example.handler.lessonVisiting;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.dtoRequest.lessonVisiting.DeleteLessonVisitingByIdRequest;
import org.example.handler.IHandler;
import org.example.ResponseEntity;
import org.example.networkOperations.controllers.LessonVisitingController;
import org.springframework.stereotype.Component;

@Component
public class DeleteLessonVisitingByIdHandler implements IHandler {
    @Override
    public String handler(Object jsonRequest) throws JsonProcessingException {

        ResponseEntity<?> deleteLessonVisitingResponse = LessonVisitingController.deleteLessonVisitingById((DeleteLessonVisitingByIdRequest) jsonRequest);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(deleteLessonVisitingResponse);
    }
}
 */
