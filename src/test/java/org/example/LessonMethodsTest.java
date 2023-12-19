package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
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
import org.example.dto_request.studentGroup.add.AddStudentGroupRequest;
import org.example.dto_request.teacher.add.AddTeacherRequest;
import org.example.dto_response.lesson.AddLessonResponse;
import org.example.dto_response.lesson.GetLessonByIdResponse;
import org.example.dto_response.lesson.GetLessonsByGroupResponse;
import org.example.dto_response.lesson.GetLessonsByTeacherResponse;
import org.example.model.Lesson;
import org.example.network_operations.ResponseEntity;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;

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

    //4. Получение уроков по группе (пограничная дата)  - получение норм дата(равная) - получение по несуществующей группе
    @Test
    public void lesson_test4() throws JsonProcessingException, ParseException {
        AddStudentGroupRequest groupRequest = new AddStudentGroupRequest("ММБ-104");
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestGroup = ow.writeValueAsString(groupRequest);
        server.processServer("addStudentGroup", jsonRequestGroup);

        AddTeacherRequest addTeacherRequest = new AddTeacherRequest("Котов", "Кот", "Котикович");
        String jsonRequestTeacher = ow.writeValueAsString(addTeacherRequest);
        server.processServer("addTeacher", jsonRequestTeacher);

        AddTeacherRequest addTeacherRequest2 = new AddTeacherRequest("Собакен", "Собака", "Собакович");
        String jsonRequestTeacher2 = ow.writeValueAsString(addTeacherRequest2);
        server.processServer("addTeacher", jsonRequestTeacher2);

        AddLessonRequest addLessonRequest = new AddLessonRequest("10-12-2015", 1, 1, 1);
        String jsonRequestLesson = ow.writeValueAsString(addLessonRequest);
        server.processServer("addLesson", jsonRequestLesson);

        AddLessonRequest addLessonRequest2 = new AddLessonRequest("10-12-2015", 2, 2, 1);
        String jsonRequestLesson2 = ow.writeValueAsString(addLessonRequest2);
        server.processServer("addLesson", jsonRequestLesson2);

        GetLessonsByGroupRequest getLessonsByGroupRequest = new GetLessonsByGroupRequest("09-09-2009", "09-12-2015", 1);
        String jsonRequest1 = ow.writeValueAsString(getLessonsByGroupRequest);
        String responseResult = server.processServer("getLessonsByGroup", jsonRequest1);

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseEntity<GetLessonsByGroupResponse> response = objectMapper.readValue(responseResult, new TypeReference<>() {
        });

        GetLessonsByGroupResponse getLessonsByGroupResponse = response.getResponseData();

        GetLessonsByGroupResponse getLessonsByGroupResponse1 = new GetLessonsByGroupResponse(new ArrayList<>());

        Assert.assertEquals(getLessonsByGroupResponse1, getLessonsByGroupResponse);

        GetLessonsByGroupRequest getLessonsByGroupRequest2 = new GetLessonsByGroupRequest("09-09-2009", "10-12-2015", 1);
        String jsonRequest2 = ow.writeValueAsString(getLessonsByGroupRequest2);
        String responseResult2 = server.processServer("getLessonsByGroup", jsonRequest2);

        ResponseEntity<GetLessonsByGroupResponse> response2 = objectMapper.readValue(responseResult2, new TypeReference<>() {
        });

        GetLessonsByGroupResponse getLessonsByGroupResponse12 = response2.getResponseData();

        DataBase dataBase = DataBase.getDataBase();
        Lesson lesson1 = dataBase.getLessonById(1);
        Lesson lesson2 = dataBase.getLessonById(2);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(lesson1.toString());
        arrayList.add(lesson2.toString());

        Assert.assertEquals(getLessonsByGroupResponse12.getListLessons(), arrayList);

        GetLessonsByGroupRequest getLessonsByGroupRequest23 = new GetLessonsByGroupRequest("09-09-2009", "10-12-2015", 15);
        String jsonRequest23 = ow.writeValueAsString(getLessonsByGroupRequest23);

        try {
            server.processServer("getLessonsByGroup", jsonRequest23);
        } catch (NullPointerException e) {
            Assert.assertEquals(e.getMessage(), "Такой группы нет в системе");
        } finally {
            dataBase.clear();
        }
    }

    //5. Валидация дат
    @Test
    public void lesson_test5() throws JsonProcessingException, ParseException {
        GetLessonsByGroupRequest getLessonsByGroupRequest = new GetLessonsByGroupRequest("40-09-2009", "09-13-2015", 1);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequest1 = ow.writeValueAsString(getLessonsByGroupRequest);
        try {
            server.processServer("getLessonsByGroup", jsonRequest1);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "[startDate  is not a date, endDate  is not a date]");
        } finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }
    }

    //6. Удаление по учителю - удаление по несуществующему учителю
    @Test
    public void lesson_test6() throws JsonProcessingException, ParseException {
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

        DeleteLessonsByTeacherRequest deleteLessonsByTeacherRequest = new DeleteLessonsByTeacherRequest(1);
        String jsonRequestLessonTeacher = ow.writeValueAsString(deleteLessonsByTeacherRequest);
        server.processServer("deleteLessonsByTeacher", jsonRequestLessonTeacher);

        DataBase dataBase = DataBase.getDataBase();

        Assert.assertNull(dataBase.getLessonById(1));

        DeleteLessonsByTeacherRequest deleteLessonsByTeacherRequest2 = new DeleteLessonsByTeacherRequest(12);
        String jsonRequestLessonTeacher2 = ow.writeValueAsString(deleteLessonsByTeacherRequest2);

        try {
            server.processServer("deleteLessonsByTeacher", jsonRequestLessonTeacher2);
        } catch (NullPointerException e) {
            Assert.assertEquals(e.getMessage(), "Такого учителя нет в системе");
        } finally {
            dataBase.clear();
        }
    }

    //7. Удаление уроков по группе - удаление уроков по несуществующей группе
    @Test
    public void lesson_test7() throws JsonProcessingException, ParseException {
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
        server.processServer("addLesson", jsonRequestLesson2);

        DeleteLessonsByGroupRequest deleteLessonsByGroupRequest = new DeleteLessonsByGroupRequest(1);
        String jsonRequestGroupDeleteT = ow.writeValueAsString(deleteLessonsByGroupRequest);
        server.processServer("deleteLessonsByGroup", jsonRequestGroupDeleteT);

        DataBase dataBase = DataBase.getDataBase();

        Assert.assertNull(dataBase.getLessonById(1));

        DeleteLessonsByGroupRequest deleteLessonsByGroupRequest2 = new DeleteLessonsByGroupRequest(15);
        String jsonRequestGroupDelete2 = ow.writeValueAsString(deleteLessonsByGroupRequest2);
        try {
            server.processServer("deleteLessonsByGroup", jsonRequestGroupDelete2);
        } catch (NullPointerException e) {
            Assert.assertEquals(e.getMessage(),"Такой группы нет в системе");
        } finally {
            dataBase.clear();
        }
    }

    //8. Получить уроки по учителю - получить уроки по несуществующему учителю
    @Test
    public void lesson_test8() throws JsonProcessingException, ParseException{
        AddStudentGroupRequest groupRequest = new AddStudentGroupRequest("ММБ-104");
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestGroup = ow.writeValueAsString(groupRequest);
        server.processServer("addStudentGroup", jsonRequestGroup);

        AddTeacherRequest addTeacherRequest = new AddTeacherRequest("Котов", "Кот", "Котикович");
        String jsonRequestTeacher = ow.writeValueAsString(addTeacherRequest);
        server.processServer("addTeacher", jsonRequestTeacher);

        AddTeacherRequest addTeacherRequest2 = new AddTeacherRequest("Собакен", "Собака", "Собакович");
        String jsonRequestTeacher2 = ow.writeValueAsString(addTeacherRequest2);
        server.processServer("addTeacher", jsonRequestTeacher2);

        AddLessonRequest addLessonRequest = new AddLessonRequest("10-12-2015", 1, 1, 1);
        String jsonRequestLesson = ow.writeValueAsString(addLessonRequest);
        server.processServer("addLesson", jsonRequestLesson);

        AddLessonRequest addLessonRequest2 = new AddLessonRequest("10-12-2015", 2, 2, 1);
        String jsonRequestLesson2 = ow.writeValueAsString(addLessonRequest2);
        server.processServer("addLesson", jsonRequestLesson2);

        GetLessonsByTeacherRequest getLessonsByTeacherRequest = new GetLessonsByTeacherRequest("10-10-2015","20-10-2023",2);
        String jsonRequestTeacherGet = ow.writeValueAsString(getLessonsByTeacherRequest);
        String result = server.processServer("getLessonsByTeacher", jsonRequestTeacherGet);

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseEntity<GetLessonsByTeacherResponse> response = objectMapper.readValue(result, new TypeReference<>() {
        });

        GetLessonsByTeacherResponse getLessonsByTeacherResponse = response.getResponseData();

        DataBase dataBase = DataBase.getDataBase();
        ArrayList<String> arrayList = new ArrayList<>();
        Lesson lesson = dataBase.getLessonById(2);
        arrayList.add(lesson.toString());

        Assert.assertEquals(getLessonsByTeacherResponse.getListLessons(),arrayList);

        GetLessonsByTeacherRequest getLessonsByTeacherRequest2 = new GetLessonsByTeacherRequest("10-10-2015","20-10-2023",3);
        String jsonRequestTeacherGet2 = ow.writeValueAsString(getLessonsByTeacherRequest2);

        try {
            server.processServer("getLessonsByTeacher", jsonRequestTeacherGet2);
        }
        catch (NullPointerException e){
            Assert.assertEquals(e.getMessage(),"Такого учителя нет в системе");
        }
        finally {
            dataBase.clear();
        }
    }
}
