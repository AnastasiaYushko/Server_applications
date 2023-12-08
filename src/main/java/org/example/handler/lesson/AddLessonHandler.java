package org.example.handler.lesson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.lesson.add.AddLessonRequest;
import org.example.dto_response.lesson.AddLessonResponse;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.LessonController;

public class AddLessonHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        AddLessonRequest addLessonRequest = objectMapper.readValue(jsonRequest, AddLessonRequest.class);

        ResponseEntity<AddLessonResponse> addLessonResponse = LessonController.addLesson(addLessonRequest);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(addLessonResponse);
    }
}
