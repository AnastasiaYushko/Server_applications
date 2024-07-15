package org.example.handler.lesson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.dto_request.lesson.get.byGroup.GetLessonsByGroupRequest;
import org.example.dto_response.lesson.GetLessonsByGroupResponse;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.LessonController;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class GetLessonsByGroupHandler implements IHandler {
    @Override
    public String handler(Object jsonRequest) throws JsonProcessingException, ParseException {

        ResponseEntity<GetLessonsByGroupResponse> getLessonsByGroupResponse = LessonController.getLessonsByGroup((GetLessonsByGroupRequest) jsonRequest);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(getLessonsByGroupResponse);
    }
}
