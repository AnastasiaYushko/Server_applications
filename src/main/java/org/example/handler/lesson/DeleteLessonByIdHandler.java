/*package org.example.handler.lesson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.dtoRequest.lesson.DeleteLessonByIdRequest;
import org.example.handler.IHandler;
import org.example.ResponseEntity;
import org.example.networkOperations.controllers.LessonController;
import org.springframework.stereotype.Component;

@Component
public class DeleteLessonByIdHandler implements IHandler {
    @Override
    public String handler(Object jsonRequest) throws JsonProcessingException {

        ResponseEntity<?> deleteLessonResponse = LessonController.deleteLessonById(((DeleteLessonByIdRequest) jsonRequest));

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(deleteLessonResponse);
    }
}
 */
