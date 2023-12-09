package org.example.services.serviceInterfaceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.lesson.add.AddLessonRequest;
import org.example.dto_request.lesson.delete.byGroup.DeleteLessonsByGroupRequest;
import org.example.dto_request.lesson.delete.byId.DeleteLessonByIdRequest;
import org.example.dto_request.lesson.delete.byTeacher.DeleteLessonsByTeacherRequest;
import org.example.dto_request.lesson.edit.EditLessonRequest;
import org.example.dto_request.lesson.get.byGroup.GetLessonsByGroupRequest;
import org.example.dto_request.lesson.get.byId.GetLessonByIdRequest;
import org.example.dto_request.lesson.get.byTeacher.GetLessonsByTeacherRequest;
import org.example.dto_response.lesson.*;
import org.example.services.serviceInterface.LessonService;

public class LessonServiceImpl implements LessonService {
    @Override
    public AddLessonResponse addLesson(AddLessonRequest request) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequest = ow.writeValueAsString(request);

        // вызов метода на сервера
        //

        String jsonResponse = "Ответ сервера на метод addLesson";
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(jsonResponse, AddLessonResponse.class);
    }

    @Override
    public String deleteLessonsByGroup(DeleteLessonsByGroupRequest request) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequest = ow.writeValueAsString(request);

        // вызов метода на сервера
        //

        return "Ответ сервера на метод deleteLessonsByGroup";
    }

    @Override
    public String deleteLessonById(DeleteLessonByIdRequest request) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequest = ow.writeValueAsString(request);

        // вызов метода на сервера
        //

        return "Ответ сервера на метод deleteLessonById";
    }

    @Override
    public String deleteLessonsByTeacher(DeleteLessonsByTeacherRequest request) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequest = ow.writeValueAsString(request);

        // вызов метода на сервера
        //

        return "Ответ сервера на метод deleteLessonsByTeacher";
    }

    @Override
    public EditLessonResponse editLesson(EditLessonRequest request) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequest = ow.writeValueAsString(request);

        // вызов метода на сервера
        //

        String jsonResponse = "Ответ сервера на метод editLesson";
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(jsonResponse, EditLessonResponse.class);
    }

    @Override
    public GetLessonsByGroupResponse getLessonsByGroup(GetLessonsByGroupRequest request) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequest = ow.writeValueAsString(request);

        // вызов метода на сервера
        //

        String jsonResponse = "Ответ сервера на метод getLessonsByGroup";
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(jsonResponse, GetLessonsByGroupResponse.class);
    }

    @Override
    public GetLessonByIdResponse getLessonById(GetLessonByIdRequest request) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequest = ow.writeValueAsString(request);

        // вызов метода на сервера
        //

        String jsonResponse = "Ответ сервера на метод getLessonById";
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(jsonResponse, GetLessonByIdResponse.class);
    }

    @Override
    public GetLessonsByTeacherResponse getLessonsByTeacher(GetLessonsByTeacherRequest request) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequest = ow.writeValueAsString(request);

        // вызов метода на сервера
        //

        String jsonResponse = "Ответ сервера на метод getLessonsByTeacher";
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(jsonResponse, GetLessonsByTeacherResponse.class);
    }
}
