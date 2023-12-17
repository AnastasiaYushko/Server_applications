package org.example.handler.lessonVisiting;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.lessonVisiting.get.GetLessonVisitingRequest;
import org.example.dto_response.lessonVisiting.GetLessonVisitingResponse;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.LessonVisitingController;

public class GetLessonVisitingHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        GetLessonVisitingRequest getLessonVisitingRequest = objectMapper.readValue(jsonRequest, GetLessonVisitingRequest.class);

        ResponseEntity<GetLessonVisitingResponse> getLessonVisitingResponse = LessonVisitingController.getLessonVisiting(getLessonVisitingRequest);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(getLessonVisitingResponse);
    }
}
