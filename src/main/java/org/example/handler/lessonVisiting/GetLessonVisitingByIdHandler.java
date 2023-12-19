package org.example.handler.lessonVisiting;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.lessonVisiting.get.byId.GetLessonVisitingByIdRequest;
import org.example.dto_response.lessonVisiting.GetLessonVisitingByIdResponse;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.LessonVisitingController;

public class GetLessonVisitingByIdHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        GetLessonVisitingByIdRequest getLessonVisitingRequest = objectMapper.readValue(jsonRequest, GetLessonVisitingByIdRequest.class);

        ResponseEntity<GetLessonVisitingByIdResponse> getLessonVisitingResponse = LessonVisitingController.getLessonVisitingById(getLessonVisitingRequest);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(getLessonVisitingResponse);
    }
}
