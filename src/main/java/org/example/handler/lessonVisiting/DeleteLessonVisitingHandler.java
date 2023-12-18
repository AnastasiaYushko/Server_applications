package org.example.handler.lessonVisiting;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.lessonVisiting.delete.DeleteLessonVisitingRequest;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.LessonVisitingController;

public class DeleteLessonVisitingHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        DeleteLessonVisitingRequest deleteLessonVisitingRequest = objectMapper.readValue(jsonRequest, DeleteLessonVisitingRequest.class);

        ResponseEntity<String> deleteLessonVisitingResponse = LessonVisitingController.deleteLessonVisiting(deleteLessonVisitingRequest);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(deleteLessonVisitingResponse);
    }
}
