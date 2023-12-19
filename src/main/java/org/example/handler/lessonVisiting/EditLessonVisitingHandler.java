package org.example.handler.lessonVisiting;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.lessonVisiting.edit.EditLessonVisitingRequest;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.LessonVisitingController;

import java.text.ParseException;

public class EditLessonVisitingHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws JsonProcessingException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();

        EditLessonVisitingRequest editLessonVisitingRequest = objectMapper.readValue(jsonRequest, EditLessonVisitingRequest.class);

        ResponseEntity<String> editStudentVisitingResponse = LessonVisitingController.editLessonVisiting(editLessonVisitingRequest);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(editStudentVisitingResponse);
    }
}
