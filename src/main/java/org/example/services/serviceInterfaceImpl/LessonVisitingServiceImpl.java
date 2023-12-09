package org.example.services.serviceInterfaceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.lessonVisiting.add.AddLessonVisitingRequest;
import org.example.dto_request.lessonVisiting.delete.DeleteLessonVisitingRequest;
import org.example.dto_request.lessonVisiting.get.GetLessonVisitingRequest;
import org.example.dto_response.lessonVisiting.GetLessonVisitingResponse;
import org.example.services.serviceInterface.LessonVisitingService;

public class LessonVisitingServiceImpl implements LessonVisitingService{
    @Override
    public String addLessonVisiting(AddLessonVisitingRequest request) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequest = ow.writeValueAsString(request);

        // вызов метода на сервера
        //

        return "Ответ сервера на метод addLessonVisiting";
    }

    @Override
    public String deleteLessonVisiting(DeleteLessonVisitingRequest request) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequest = ow.writeValueAsString(request);

        // вызов метода на сервера
        //

        return "Ответ сервера на метод deleteLessonVisiting";
    }

    @Override
    public GetLessonVisitingResponse getLessonVisiting(GetLessonVisitingRequest request) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequest = ow.writeValueAsString(request);

        // вызов метода на сервера
        //

        String jsonResponse = "Ответ сервера на метод getLessonVisiting";
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(jsonResponse, GetLessonVisitingResponse.class);
    }
}
