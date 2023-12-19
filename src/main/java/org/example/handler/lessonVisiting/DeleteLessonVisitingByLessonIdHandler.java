package org.example.handler.lessonVisiting;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.lessonVisiting.delete.byLessonId.DeleteLessonVisitingByLessonIdRequest;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.LessonVisitingController;

import java.text.ParseException;

public class DeleteLessonVisitingByLessonIdHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws JsonProcessingException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();

        DeleteLessonVisitingByLessonIdRequest deleteLessonVisitingRequest = objectMapper.readValue(jsonRequest, DeleteLessonVisitingByLessonIdRequest.class);

        ResponseEntity<String> deleteLessonVisitingResponse = LessonVisitingController.deleteLessonVisitingByLessonId(deleteLessonVisitingRequest);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(deleteLessonVisitingResponse);
    }
}
