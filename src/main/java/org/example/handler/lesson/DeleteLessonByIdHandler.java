package org.example.handler.lesson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.lesson.delete.byId.DeleteLessonByIdRequest;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.LessonController;

public class DeleteLessonByIdHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        DeleteLessonByIdRequest deleteLessonByIdRequest = objectMapper.readValue(jsonRequest, DeleteLessonByIdRequest.class);

        ResponseEntity<String> deleteLessonResponse = LessonController.deleteLessonById(deleteLessonByIdRequest);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(deleteLessonResponse);
    }
}
