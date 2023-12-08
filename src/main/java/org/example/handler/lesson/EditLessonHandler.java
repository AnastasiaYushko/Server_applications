package org.example.handler.lesson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.lesson.edit.EditLessonRequest;
import org.example.dto_response.lesson.EditLessonResponse;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.LessonController;

public class EditLessonHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        EditLessonRequest editLessonRequest = objectMapper.readValue(jsonRequest, EditLessonRequest.class);

        ResponseEntity<EditLessonResponse> editLessonResponse = LessonController.editLesson(editLessonRequest);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(editLessonResponse);
    }
}
