/*package org.example.handler.lesson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.dtoRequest.lesson.DeleteLessonsByTeacherRequest;
import org.example.handler.IHandler;
import org.example.ResponseEntity;
import org.example.networkOperations.controllers.LessonController;
import org.springframework.stereotype.Component;

@Component
public class DeleteLessonsByTeacherHandler implements IHandler {
    @Override
    public String handler(Object jsonRequest) throws JsonProcessingException {

        ResponseEntity<?> deleteLessonResponse = LessonController.deleteLessonsByTeacher((DeleteLessonsByTeacherRequest) jsonRequest);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(deleteLessonResponse);
    }
}
 */
