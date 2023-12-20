package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.lesson.add.AddLessonRequest;
import org.example.dto_request.lesson.delete.byId.DeleteLessonByIdRequest;
import org.example.dto_request.lessonVisiting.add.AddLessonVisitingRequest;
import org.example.dto_request.lessonVisiting.delete.byId.DeleteLessonVisitingByIdRequest;
import org.example.dto_request.lessonVisiting.delete.byLessonId.DeleteLessonVisitingByLessonIdRequest;
import org.example.dto_request.lessonVisiting.edit.EditLessonVisitingRequest;
import org.example.dto_request.lessonVisiting.get.byILessonId.GetLessonVisitingByLessonIdRequest;
import org.example.dto_request.lessonVisiting.get.byId.GetLessonVisitingByIdRequest;
import org.example.dto_request.studentGroup.add.AddStudentGroupRequest;
import org.example.dto_request.teacher.add.AddTeacherRequest;
import org.example.dto_response.lessonVisiting.AddLessonVisitingResponse;
import org.example.dto_response.lessonVisiting.GetLessonVisitingByIdResponse;
import org.example.dto_response.lessonVisiting.GetLessonVisitingByLessonIdResponse;
import org.example.enums.StatusStudent;
import org.example.model.LessonVisiting;
import org.example.model.Student;
import org.example.model.StudentGroup;
import org.example.network_operations.ResponseEntity;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;

public class LessonVisitingMethodsTest {

    Server server = new Server();

    // 1. Добавить посещаемость - добавить посещаемость к несуществующему уроку
    @Test
    public void lessonVisiting_test1() throws JsonProcessingException, ParseException {

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

        StudentGroup studentGroup = new StudentGroup(1, "ММБ-102");
        StatusStudent statusStudent = StatusStudent.STUDIES;
        Student student1 = new Student(1, "Филиппов", "Илья", "Иванович", statusStudent, studentGroup);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(student1.toString());
        AddLessonVisitingRequest addLessonVisitingRequest = new AddLessonVisitingRequest(1, arrayList);
        String jsonRequestLessonVisiting = ow.writeValueAsString(addLessonVisitingRequest);

        String result = server.processServer("addLessonVisiting", jsonRequestLessonVisiting);

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseEntity<AddLessonVisitingResponse> response = objectMapper.readValue(result, new TypeReference<>() {
        });

        AddLessonVisitingResponse addLessonResponse = response.getResponseData();

        AddLessonVisitingResponse addLessonResponse1 = new AddLessonVisitingResponse(1);

        Assert.assertEquals(addLessonResponse1, addLessonResponse);

        AddLessonVisitingRequest addLessonVisitingRequest2 = new AddLessonVisitingRequest(2, arrayList);
        String jsonRequestLessonVisiting2 = ow.writeValueAsString(addLessonVisitingRequest2);

        try {
            server.processServer("addLessonVisiting", jsonRequestLessonVisiting2);
        } catch (NullPointerException e) {
            Assert.assertEquals(e.getMessage(), "Такого урока нет в системе");
        } finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }
    }

    // 2. Добавление когда уже есть
    @Test
    public void lessonVisiting_test2() throws JsonProcessingException, ParseException {
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

        StudentGroup studentGroup = new StudentGroup(1, "ММБ-102");
        StatusStudent statusStudent = StatusStudent.STUDIES;
        Student student1 = new Student(1, "Филиппов", "Илья", "Иванович", statusStudent, studentGroup);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(student1.toString());
        AddLessonVisitingRequest addLessonVisitingRequest = new AddLessonVisitingRequest(1, arrayList);
        String jsonRequestLessonVisiting = ow.writeValueAsString(addLessonVisitingRequest);

        server.processServer("addLessonVisiting", jsonRequestLessonVisiting);

        Student student2 = new Student(2, "Тимофеев", "Тимофей", "Котович", statusStudent, studentGroup);
        arrayList.add(student2.toString());
        AddLessonVisitingRequest addLessonVisitingRequest2 = new AddLessonVisitingRequest(1, arrayList);
        String jsonRequestLessonVisiting2 = ow.writeValueAsString(addLessonVisitingRequest2);

        try {
            server.processServer("addLessonVisiting", jsonRequestLessonVisiting2);
        } catch (NullPointerException e) {
            Assert.assertEquals(e.getMessage(), "Посещаемость данного урока уже есть в системе");
        } finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }
    }

    // 3. Удалить по несуществующему уроку
    @Test
    public void lessonVisiting_test3() throws JsonProcessingException, ParseException {
        DeleteLessonVisitingByLessonIdRequest deleteLessonVisitingByIdRequest = new DeleteLessonVisitingByLessonIdRequest(1);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestLessonVisiting = ow.writeValueAsString(deleteLessonVisitingByIdRequest);

        try {
            server.processServer("deleteLessonVisitingByLessonId", jsonRequestLessonVisiting);
        } catch (NullPointerException e) {
            Assert.assertEquals(e.getMessage(), "Такого урока нет в системе");
        } finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }
    }

    //4. Удалить по несуществующей посещаемости
    @Test
    public void lessonVisiting_test4() throws JsonProcessingException, ParseException {
        DeleteLessonVisitingByIdRequest deleteLessonVisitingByIdRequest = new DeleteLessonVisitingByIdRequest(1);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestLessonVisiting = ow.writeValueAsString(deleteLessonVisitingByIdRequest);

        try {
            server.processServer("deleteLessonVisitingById", jsonRequestLessonVisiting);
        } catch (NullPointerException e) {
            Assert.assertEquals(e.getMessage(), "Такой посещаемости нет в системе");
        } finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }
    }

    // 5. Удалить по уроку - получить по несуществующему уроку
    @Test
    public void lessonVisiting_test5() throws JsonProcessingException, ParseException {
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

        StudentGroup studentGroup = new StudentGroup(1, "ММБ-102");
        StatusStudent statusStudent = StatusStudent.STUDIES;
        Student student1 = new Student(1, "Филиппов", "Илья", "Иванович", statusStudent, studentGroup);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(student1.toString());
        AddLessonVisitingRequest addLessonVisitingRequest = new AddLessonVisitingRequest(1, arrayList);
        String jsonRequestLessonVisiting = ow.writeValueAsString(addLessonVisitingRequest);

        server.processServer("addLessonVisiting", jsonRequestLessonVisiting);

        DeleteLessonVisitingByLessonIdRequest deleteLessonVisitingByLessonIdRequest = new DeleteLessonVisitingByLessonIdRequest(1);
        String jsonRequest = ow.writeValueAsString(deleteLessonVisitingByLessonIdRequest);
        server.processServer("deleteLessonVisitingByLessonId", jsonRequest);

        DataBase dataBase = DataBase.getDataBase();

        GetLessonVisitingByLessonIdRequest getLessonVisitingByLessonIdRequest = new GetLessonVisitingByLessonIdRequest(1);
        String jsonRequest2 = ow.writeValueAsString(getLessonVisitingByLessonIdRequest);

        try {
            server.processServer("getLessonVisitingByLessonId", jsonRequest2);
        } catch (NullPointerException e) {
            Assert.assertEquals(e.getMessage(), "Данных о посещаемость данного урока нет в системе");
        } finally {
            dataBase.clear();
        }
    }

    // 6. При удалении урока => удалится посещаемость
    @Test
    public void lessonVisiting_test6() throws JsonProcessingException, ParseException {
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

        StudentGroup studentGroup = new StudentGroup(1, "ММБ-102");
        StatusStudent statusStudent = StatusStudent.STUDIES;
        Student student1 = new Student(1, "Филиппов", "Илья", "Иванович", statusStudent, studentGroup);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(student1.toString());
        AddLessonVisitingRequest addLessonVisitingRequest = new AddLessonVisitingRequest(1, arrayList);
        String jsonRequestLessonVisiting = ow.writeValueAsString(addLessonVisitingRequest);

        server.processServer("addLessonVisiting", jsonRequestLessonVisiting);

        DeleteLessonByIdRequest deleteLessonByIdRequest = new DeleteLessonByIdRequest(1);
        String jsonRequestLesson1 = ow.writeValueAsString(deleteLessonByIdRequest);
        server.processServer("deleteLessonById", jsonRequestLesson1);

        DataBase dataBase = DataBase.getDataBase();

        Assert.assertNull(dataBase.getLessonVisitingByLessonId(1));

        dataBase.clear();
    }

    // 7.Получить по уроку = получить по id   - получить если нет посещаемость
    @Test
    public void lessonVisiting_test7() throws JsonProcessingException, ParseException {
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

        StudentGroup studentGroup = new StudentGroup(1, "ММБ-102");
        StatusStudent statusStudent = StatusStudent.STUDIES;
        Student student1 = new Student(1, "Филиппов", "Илья", "Иванович", statusStudent, studentGroup);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(student1.toString());
        AddLessonVisitingRequest addLessonVisitingRequest = new AddLessonVisitingRequest(1, arrayList);
        String jsonRequestLessonVisiting = ow.writeValueAsString(addLessonVisitingRequest);

        server.processServer("addLessonVisiting", jsonRequestLessonVisiting);

        GetLessonVisitingByLessonIdRequest getLessonVisitingByLessonIdRequest = new GetLessonVisitingByLessonIdRequest(1);
        String jsonRequest1 = ow.writeValueAsString(getLessonVisitingByLessonIdRequest);
        String result = server.processServer("getLessonVisitingByLessonId", jsonRequest1);

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseEntity<GetLessonVisitingByLessonIdResponse> response = objectMapper.readValue(result, new TypeReference<>() {
        });

        GetLessonVisitingByLessonIdResponse getLessonVisitingByIdResponse = response.getResponseData();

        LessonVisiting lessonVisiting = new LessonVisiting(1, 1, arrayList);

        GetLessonVisitingByLessonIdResponse getLessonVisitingByLessonIdResponse1 = new GetLessonVisitingByLessonIdResponse(lessonVisiting.toString());

        Assert.assertEquals(getLessonVisitingByIdResponse, getLessonVisitingByLessonIdResponse1);

        GetLessonVisitingByIdRequest getLessonVisitingByIdRequest = new GetLessonVisitingByIdRequest(1);
        String jsonRequest2 = ow.writeValueAsString(getLessonVisitingByIdRequest);
        String result2 = server.processServer("getLessonVisitingById", jsonRequest2);
        ResponseEntity<GetLessonVisitingByIdResponse> response2 = objectMapper.readValue(result2, new TypeReference<>() {
        });

        GetLessonVisitingByIdResponse getLessonVisitingByIdResponse1 = response2.getResponseData();

        Assert.assertEquals(getLessonVisitingByIdResponse1.getLessonVisiting(), getLessonVisitingByIdResponse.getLessonVisiting());

        GetLessonVisitingByIdRequest getLessonVisitingByIdRequest2 = new GetLessonVisitingByIdRequest(2);
        String jsonRequest22 = ow.writeValueAsString(getLessonVisitingByIdRequest2);

        try {
            server.processServer("getLessonVisitingById", jsonRequest22);
        } catch (NullPointerException e) {
            Assert.assertEquals(e.getMessage(),"Данных о посещаемость данного урока нет в системе");
        } finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }
    }

    // 8. Изменить посещаемость - изменение нет урока
    @Test
    public void lessonVisiting_test8() throws JsonProcessingException, ParseException {
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

        StudentGroup studentGroup = new StudentGroup(1, "ММБ-102");
        StatusStudent statusStudent = StatusStudent.STUDIES;
        Student student1 = new Student(1, "Филиппов", "Илья", "Иванович", statusStudent, studentGroup);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(student1.toString());
        AddLessonVisitingRequest addLessonVisitingRequest = new AddLessonVisitingRequest(1, arrayList);
        String jsonRequestLessonVisiting = ow.writeValueAsString(addLessonVisitingRequest);

        server.processServer("addLessonVisiting", jsonRequestLessonVisiting);

        DataBase dataBase = DataBase.getDataBase();
        LessonVisiting lessonVisiting1 = dataBase.getLessonVisitingById(1);

        Student student2 = new Student(2, "Филиппова", "Инна", "Ивановна", statusStudent, studentGroup);
        arrayList.add(student2.toString());
        EditLessonVisitingRequest editLessonVisitingRequest = new EditLessonVisitingRequest(1, 1, arrayList);
        String jsonRequest1 = ow.writeValueAsString(editLessonVisitingRequest);
        server.processServer("editLessonVisiting", jsonRequest1);

        LessonVisiting lessonVisiting2 = dataBase.getLessonVisitingById(1);

        Assert.assertNotEquals(lessonVisiting2, lessonVisiting1);

        EditLessonVisitingRequest editLessonVisitingRequest2 = new EditLessonVisitingRequest(1, 2, arrayList);
        String jsonRequest2 = ow.writeValueAsString(editLessonVisitingRequest2);

        try {
            server.processServer("editLessonVisiting", jsonRequest2);
        } catch (NullPointerException e) {
            Assert.assertEquals(e.getMessage(), "Такого урока нет в системе");
        } finally {
            dataBase.clear();
        }
    }

    // 9. Изменить несуществующую посещаемость
    @Test
    public void lessonVisiting_test9() throws JsonProcessingException, ParseException {

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

        StudentGroup studentGroup = new StudentGroup(1, "ММБ-102");
        StatusStudent statusStudent = StatusStudent.STUDIES;
        Student student1 = new Student(1, "Филиппов", "Илья", "Иванович", statusStudent, studentGroup);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(student1.toString());

        EditLessonVisitingRequest editLessonVisitingRequest = new EditLessonVisitingRequest(1, 1, arrayList);
        String jsonRequest1 = ow.writeValueAsString(editLessonVisitingRequest);

        try {
            server.processServer("editLessonVisiting", jsonRequest1);
        } catch (NullPointerException e) {
            Assert.assertEquals(e.getMessage(), "Посещаемость, которую вы хотите изменить - нет в системе");
        } finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }
    }

}
