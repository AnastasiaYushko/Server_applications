package org.example.handler.lesson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.lesson.get.byTeacher.GetLessonsByTeacherRequest;
import org.example.dto_response.lesson.GetLessonsByTeacherResponse;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.LessonController;

import java.text.ParseException;

public class GetLessonByTeacherHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws JsonProcessingException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();

        GetLessonsByTeacherRequest getLessonsByTeacherRequest = objectMapper.readValue(jsonRequest, GetLessonsByTeacherRequest.class);

        ResponseEntity<GetLessonsByTeacherResponse> getLessonsByTeacherResponse = LessonController.getLessonsByTeacher(getLessonsByTeacherRequest);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(getLessonsByTeacherResponse);
    }
}
