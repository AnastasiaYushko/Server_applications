/*package org.example.handler.lesson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.dtoRequest.lesson.GetLessonsByTeacherRequest;
import org.example.handler.IHandler;
import org.example.ResponseEntity;
import org.example.networkOperations.controllers.LessonController;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class GetLessonByTeacherHandler implements IHandler {
    @Override
    public String handler(Object jsonRequest) throws JsonProcessingException, ParseException {

        ResponseEntity<?> getLessonsByTeacherResponse = LessonController.getLessonsByTeacher((GetLessonsByTeacherRequest) jsonRequest);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(getLessonsByTeacherResponse);
    }
}
 */
