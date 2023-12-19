package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.lesson.add.AddLessonRequest;
import org.example.dto_request.lesson.delete.byId.DeleteLessonByIdRequest;
import org.example.dto_request.lesson.edit.EditLessonRequest;
import org.example.dto_request.lesson.get.byId.GetLessonByIdRequest;
import org.example.dto_request.studentGroup.add.AddStudentGroupRequest;
import org.example.dto_request.teacher.add.AddTeacherRequest;
import org.example.dto_response.lesson.AddLessonResponse;
import org.example.dto_response.lesson.GetLessonByIdResponse;
import org.example.network_operations.ResponseEntity;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;

public class LessonMethodsTest {

    Server server = new Server();

    //1. Добавление уроков - получение по ID - удаление по ID - получить по ID несуществующий
    @Test
    public void lesson_test1() throws JsonProcessingException, ParseException {
        AddStudentGroupRequest groupRequest = new AddStudentGroupRequest("ММБ-104");
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestGroup = ow.writeValueAsString(groupRequest);
        server.processServer("addStudentGroup", jsonRequestGroup);

        AddTeacherRequest addTeacherRequest = new AddTeacherRequest("Котов", "Кот", "Котикович");
        String jsonRequestTeacher = ow.writeValueAsString(addTeacherRequest);
        server.processServer("addTeacher", jsonRequestTeacher);

        AddLessonRequest addLessonRequest = new AddLessonRequest("10-12-2015", 1, 1, 1);
        String jsonRequestLesson = ow.writeValueAsString(addLessonRequest);
        server.processServer("addLesson", jsonRequestLesson);

        AddLessonRequest addLessonRequest2 = new AddLessonRequest("10-12-2015", 2, 1, 1);
        String jsonRequestLesson2 = ow.writeValueAsString(addLessonRequest2);
        String result = server.processServer("addLesson", jsonRequestLesson2);

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseEntity<AddLessonResponse> response = objectMapper.readValue(result, new TypeReference<>() {
        });

        AddLessonResponse addLessonResponse1 = response.getResponseData();

        AddLessonResponse addLessonResponse2 = new AddLessonResponse(2);

        Assert.assertEquals(addLessonResponse1, addLessonResponse2);

        GetLessonByIdRequest getLessonByIdRequest = new GetLessonByIdRequest(2);
        String jsonRequestLesson3 = ow.writeValueAsString(getLessonByIdRequest);
        String result2 = server.processServer("getLessonById", jsonRequestLesson3);

        ResponseEntity<GetLessonByIdResponse> response2 = objectMapper.readValue(result2, new TypeReference<>() {
        });

        GetLessonByIdResponse getLessonByIdResponse = response2.getResponseData();

        GetLessonByIdResponse getLessonByIdResponse2 = new GetLessonByIdResponse("10-12-2015", 2, 1, 1);

        Assert.assertEquals(getLessonByIdResponse, getLessonByIdResponse2);

        DeleteLessonByIdRequest deleteLessonByIdRequest = new DeleteLessonByIdRequest(1);
        String jsonRequestLesson4 = ow.writeValueAsString(deleteLessonByIdRequest);
        server.processServer("deleteLessonById", jsonRequestLesson4);

        GetLessonByIdRequest getLessonByIdRequest2 = new GetLessonByIdRequest(1);
        String jsonRequestLesson5 = ow.writeValueAsString(getLessonByIdRequest2);

        try {
            server.processServer("getLessonById", jsonRequestLesson5);
        } catch (NullPointerException e) {
            Assert.assertEquals(e.getMessage(), "Такого урока нет в системе");
        } finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }

    }

    //2. Изменить урок - изменить несуществующий
    @Test
    public void lesson_test2() throws JsonProcessingException, ParseException {
        AddStudentGroupRequest groupRequest = new AddStudentGroupRequest("ММБ-104");
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestGroup = ow.writeValueAsString(groupRequest);
        server.processServer("addStudentGroup", jsonRequestGroup);

        AddTeacherRequest addTeacherRequest = new AddTeacherRequest("Котов", "Кот", "Котикович");
        String jsonRequestTeacher = ow.writeValueAsString(addTeacherRequest);
        server.processServer("addTeacher", jsonRequestTeacher);

        AddLessonRequest addLessonRequest = new AddLessonRequest("10-12-2015", 1, 1, 1);
        String jsonRequestLesson = ow.writeValueAsString(addLessonRequest);
        server.processServer("addLesson", jsonRequestLesson);

        EditLessonRequest editLessonRequest = new EditLessonRequest(1, "10-12-2016", 5, 1, 1);
        String jsonRequestLesson2 = ow.writeValueAsString(editLessonRequest);
        server.processServer("editLesson", jsonRequestLesson2);

        GetLessonByIdRequest getLessonByIdRequest = new GetLessonByIdRequest(1);
        String jsonRequestLesson3 = ow.writeValueAsString(getLessonByIdRequest);
        String result2 = server.processServer("getLessonById", jsonRequestLesson3);

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseEntity<GetLessonByIdResponse> response2 = objectMapper.readValue(result2, new TypeReference<>() {
        });

        GetLessonByIdResponse getLessonByIdResponse = response2.getResponseData();

        GetLessonByIdResponse getLessonByIdResponse1 = new GetLessonByIdResponse("10-12-2016", 5, 1, 1);

        Assert.assertEquals(getLessonByIdResponse, getLessonByIdResponse1);

        EditLessonRequest editLessonRequest2 = new EditLessonRequest(22, "10-12-2016", 5, 1, 1);
        String jsonRequestLesson4 = ow.writeValueAsString(editLessonRequest2);

        try {
            server.processServer("editLesson", jsonRequestLesson4);
        } catch (NullPointerException e) {
            Assert.assertEquals(e.getMessage(), "Такого урока нет в системе");
        } finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }
    }

    //3. Удаление по ID несуществующего
    @Test
    public void lesson_test3() throws JsonProcessingException, ParseException {

        DeleteLessonByIdRequest deleteLessonByIdRequest = new DeleteLessonByIdRequest(1);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestLesson4 = ow.writeValueAsString(deleteLessonByIdRequest);

        try {
            server.processServer("deleteLessonById", jsonRequestLesson4);
        } catch (NullPointerException e) {
            Assert.assertEquals(e.getMessage(), "Такого урока нет в системе");
        } finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }

    }
}
