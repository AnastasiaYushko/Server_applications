/*
package org.example.handler.lessonVisiting;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.dtoRequest.lessonVisiting.EditLessonVisitingRequest;
import org.example.handler.IHandler;
import org.example.ResponseEntity;
import org.example.networkOperations.controllers.LessonVisitingController;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class EditLessonVisitingHandler implements IHandler {
    @Override
    public String handler(Object jsonRequest) throws JsonProcessingException, ParseException {

        ResponseEntity<?> editStudentVisitingResponse = LessonVisitingController.editLessonVisiting((EditLessonVisitingRequest) jsonRequest);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(editStudentVisitingResponse);
    }
}
 */
