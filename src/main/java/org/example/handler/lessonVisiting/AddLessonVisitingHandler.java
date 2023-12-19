package org.example.handler.lessonVisiting;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.lessonVisiting.add.AddLessonVisitingRequest;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.LessonVisitingController;

public class AddLessonVisitingHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        AddLessonVisitingRequest addLessonVisitingRequest = objectMapper.readValue(jsonRequest, AddLessonVisitingRequest.class);

        ResponseEntity<String> addStudentVisitingResponse = LessonVisitingController.addLessonVisiting(addLessonVisitingRequest);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(addStudentVisitingResponse);
    }
}
