/*
package org.example.handler.lessonVisiting;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.dtoRequest.lessonVisiting.DeleteLessonVisitingByLessonIdRequest;
import org.example.handler.IHandler;
import org.example.ResponseEntity;
import org.example.networkOperations.controllers.LessonVisitingController;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class DeleteLessonVisitingByLessonIdHandler implements IHandler {
    @Override
    public String handler(Object jsonRequest) throws JsonProcessingException, ParseException {

        ResponseEntity<?> deleteLessonVisitingResponse = LessonVisitingController.deleteLessonVisitingByLessonId((DeleteLessonVisitingByLessonIdRequest) jsonRequest);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(deleteLessonVisitingResponse);
    }
}
 */
