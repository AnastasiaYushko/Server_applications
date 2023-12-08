package org.example.handler.lesson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.lesson.get.byId.GetLessonByIdRequest;
import org.example.dto_response.lesson.GetLessonByIdResponse;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.LessonController;

public class GetLessonByIdHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        GetLessonByIdRequest getLessonByIdRequest = objectMapper.readValue(jsonRequest, GetLessonByIdRequest.class);

        ResponseEntity<GetLessonByIdResponse> getLessonByIdResponse = LessonController.getLessonById(getLessonByIdRequest);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(getLessonByIdResponse);
    }
}
