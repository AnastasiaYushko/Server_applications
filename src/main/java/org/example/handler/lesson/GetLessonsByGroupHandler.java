package org.example.handler.lesson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.lesson.get.byGroup.GetLessonsByGroupRequest;
import org.example.dto_response.lesson.GetLessonsByGroupResponse;
import org.example.handler.IHandler;
import org.example.network_operations.ResponseEntity;
import org.example.network_operations.controllers.LessonController;

public class GetLessonsByGroupHandler implements IHandler {
    @Override
    public String handler(String jsonRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        GetLessonsByGroupRequest getLessonsByGroupRequest = objectMapper.readValue(jsonRequest, GetLessonsByGroupRequest.class);

        ResponseEntity<GetLessonsByGroupResponse> getLessonsByGroupResponse = LessonController.getLessonsByGroup(getLessonsByGroupRequest);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        return ow.writeValueAsString(getLessonsByGroupResponse);
    }
}
