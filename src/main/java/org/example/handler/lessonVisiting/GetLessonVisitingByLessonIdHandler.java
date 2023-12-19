package org.example.handler.lessonVisiting;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.lessonVisiting.get.byILessonId.GetLessonVisitingByLessonIdRequest;
import org.example.dto_response.lessonVisiting.GetLessonVisitingByLessonIdResponse;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.LessonVisitingController;

import java.text.ParseException;

public class GetLessonVisitingByLessonIdHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws JsonProcessingException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();

        GetLessonVisitingByLessonIdRequest getLessonVisitingRequest = objectMapper.readValue(jsonRequest, GetLessonVisitingByLessonIdRequest.class);

        ResponseEntity<GetLessonVisitingByLessonIdResponse> getLessonVisitingResponse = LessonVisitingController.getLessonVisitingByLessonId(getLessonVisitingRequest);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(getLessonVisitingResponse);
    }
}
