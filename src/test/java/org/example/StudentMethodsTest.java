package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.student.add.AddStudentRequest;
import org.example.dto_request.student.delete.DeleteStudentRequest;
import org.example.dto_request.student.edit.EditStudentRequest;
import org.example.dto_request.student.get.byGroup.GetStudentsByGroupRequest;
import org.example.dto_request.student.get.byId.GetStudentByIdRequest;
import org.example.dto_request.studentGroup.add.AddStudentGroupRequest;
import org.example.dto_response.student.AddStudentResponse;
import org.example.dto_response.student.GetStudentByIdResponse;
import org.example.dto_response.student.GetStudentsByGroupResponse;
import org.example.model.Student;
import org.example.network_operations.ResponseEntity;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;

public class StudentMethodsTest {

    Server server = new Server();

    //1. Добавление студентов несколько раз
    @Test
    public void test_student_1() throws JsonProcessingException, ParseException {

        //добавили группу перед добавлением студента
        AddStudentGroupRequest groupRequest = new AddStudentGroupRequest("ММБ-104");
        ObjectWriter ow0 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestGroup = ow0.writeValueAsString(groupRequest);
        server.processServer("addStudentGroup", jsonRequestGroup);

        //Добавляем первого студента
        AddStudentRequest studentRequest1 = new AddStudentRequest("Котов", "Кот", "Котикович", "EXPELLED", "1");
        ObjectWriter ow1 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestStudent1 = ow1.writeValueAsString(studentRequest1);

        String jsonResponse1 = server.processServer("addStudent", jsonRequestStudent1);

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseEntity<AddStudentResponse> response1 = objectMapper.readValue(jsonResponse1, new TypeReference<>() {
        });
        AddStudentResponse objectResponse1 = response1.getResponseData();

        Assert.assertEquals(objectResponse1.getId(), 1);

        //Добавляем второго студента
        AddStudentRequest studentRequest2 = new AddStudentRequest("Собакен", "Собака", "Собакович", "ACADEMIC_LEAVE", "1");
        ObjectWriter ow2 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestStudent2 = ow2.writeValueAsString(studentRequest2);

        String jsonResponse2 = server.processServer("addStudent", jsonRequestStudent2);
        ResponseEntity<AddStudentResponse> response2 = objectMapper.readValue(jsonResponse2, new TypeReference<>() {
        });
        AddStudentResponse objectResponse2 = response2.getResponseData();

        Assert.assertEquals(objectResponse2.getId(), 2);

        DataBase dataBase = DataBase.getDataBase();
        dataBase.clear();
    }

    //2. Удаление и получение его же
    @Test(expected = NullPointerException.class)
    public void test_student_2() throws Exception {

        AddStudentGroupRequest groupRequest = new AddStudentGroupRequest("ММБ-104");
        ObjectWriter ow0 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestGroup = ow0.writeValueAsString(groupRequest);
        server.processServer("addStudentGroup", jsonRequestGroup);

        AddStudentRequest studentRequest1 = new AddStudentRequest("Котов", "Кот", "Котикович", "EXPELLED", "1");
        ObjectWriter ow1 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestStudent1 = ow1.writeValueAsString(studentRequest1);

        String jsonResponse1 = server.processServer("addStudent", jsonRequestStudent1);

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseEntity<AddStudentResponse> response1 = objectMapper.readValue(jsonResponse1, new TypeReference<>() {
        });
        AddStudentResponse objectResponse1 = response1.getResponseData();

        Assert.assertEquals(objectResponse1.getId(), 1);

        DeleteStudentRequest deleteStudentRequest = new DeleteStudentRequest(1);
        ObjectWriter ow2 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestStudent2 = ow2.writeValueAsString(deleteStudentRequest);

        String response = server.processServer("deleteStudent", jsonRequestStudent2);
        ResponseEntity<String> response12 = objectMapper.readValue(response, new TypeReference<>() {
        });
        Assert.assertEquals("Студент удален",response12.getResponseData());

        GetStudentByIdRequest getStudentByIdRequest = new GetStudentByIdRequest(objectResponse1.getId());
        ObjectWriter ow3 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestStudent3 = ow3.writeValueAsString(getStudentByIdRequest);

        //тут возникнет исключение
        //Получение студента,которого удалили
        try {
            server.processServer("getStudentById", jsonRequestStudent3);
        } finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }

    }

    //3. Удаление и удаление несуществующего студента
    @Test(expected = Exception.class)
    public void test_student_3() throws Exception {

        AddStudentGroupRequest groupRequest = new AddStudentGroupRequest("ММБ-104");
        ObjectWriter ow0 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestGroup = ow0.writeValueAsString(groupRequest);
        server.processServer("addStudentGroup", jsonRequestGroup);

        AddStudentRequest studentRequest1 = new AddStudentRequest("Котов", "Кот", "Котикович", "EXPELLED", "1");
        ObjectWriter ow1 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestStudent1 = ow1.writeValueAsString(studentRequest1);

        String jsonResponse1 = server.processServer("addStudent", jsonRequestStudent1);

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseEntity<AddStudentResponse> response1 = objectMapper.readValue(jsonResponse1, new TypeReference<>() {
        });
        AddStudentResponse objectResponse1 = response1.getResponseData();

        Assert.assertEquals(objectResponse1.getId(), 1);

        DeleteStudentRequest deleteStudentRequest = new DeleteStudentRequest(1);
        ObjectWriter ow2 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestStudent2 = ow2.writeValueAsString(deleteStudentRequest);

        server.processServer("deleteStudent", jsonRequestStudent2);

        DeleteStudentRequest deleteStudentRequest2 = new DeleteStudentRequest(1);
        ObjectWriter ow3 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestStudent3 = ow3.writeValueAsString(deleteStudentRequest2);

        try {
            server.processServer("deleteStudent", jsonRequestStudent3);
        } finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }
    }

    //4. Изменение и изменение несуществующего студента
    @Test(expected = Exception.class)
    public void test_student_4() throws Exception {

        AddStudentGroupRequest groupRequest = new AddStudentGroupRequest("ММБ-104");
        ObjectWriter ow0 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestGroup = ow0.writeValueAsString(groupRequest);
        server.processServer("addStudentGroup", jsonRequestGroup);

        AddStudentRequest studentRequest1 = new AddStudentRequest("Котов", "Кот", "Котикович", "EXPELLED", "1");
        ObjectWriter ow1 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestStudent1 = ow1.writeValueAsString(studentRequest1);

        server.processServer("addStudent", jsonRequestStudent1);

        EditStudentRequest editStudentRequest2 = new EditStudentRequest(1, "Петров", "Петр", "Евгеньевич", "STUDIES", "1");
        ObjectWriter ow2 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestStudent2 = ow2.writeValueAsString(editStudentRequest2);

        DataBase dataBase = DataBase.getDataBase();
        Student student1 = dataBase.getStudentById(1);
        server.processServer("editStudent", jsonRequestStudent2);
        Student student2 = dataBase.getStudentById(1);

        Assert.assertNotEquals(student1, student2);

        EditStudentRequest editStudentRequest3 = new EditStudentRequest(6, "Петров", "Петр", "Евгеньевич", "STUDIES", "1");
        ObjectWriter ow3 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestStudent3 = ow3.writeValueAsString(editStudentRequest3);

        try {
            server.processServer("editStudent", jsonRequestStudent3);
        } finally {
            dataBase = DataBase.getDataBase();
            dataBase.clear();
        }

        dataBase.clear();
    }

    //5. Получение по id и получение несуществующего студента
    @Test(expected = NullPointerException.class)
    public void test_student_5() throws Exception {

        AddStudentGroupRequest groupRequest = new AddStudentGroupRequest("ММБ-104");
        ObjectWriter ow0 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestGroup = ow0.writeValueAsString(groupRequest);
        server.processServer("addStudentGroup", jsonRequestGroup);

        AddStudentRequest studentRequest1 = new AddStudentRequest("Котов", "Кот", "Котикович", "EXPELLED", "1");
        ObjectWriter ow1 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestStudent1 = ow1.writeValueAsString(studentRequest1);

        server.processServer("addStudent", jsonRequestStudent1);

        GetStudentByIdRequest getStudentByIdRequest = new GetStudentByIdRequest(1);
        ObjectWriter ow2 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestStudent2 = ow2.writeValueAsString(getStudentByIdRequest);
        String jsonResponse1 = server.processServer("getStudentById", jsonRequestStudent2);

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseEntity<GetStudentByIdResponse> response1 = objectMapper.readValue(jsonResponse1, new TypeReference<>() {
        });
        GetStudentByIdResponse objectResponse1 = response1.getResponseData();

        GetStudentByIdResponse objectResponse2 = new GetStudentByIdResponse("Котов", "Кот", "Котикович", "EXPELLED", "ММБ-104");

        Assert.assertEquals(objectResponse1, objectResponse2);

        GetStudentByIdRequest getStudentByIdRequest2 = new GetStudentByIdRequest(2);
        ObjectWriter ow3 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestStudent3 = ow3.writeValueAsString(getStudentByIdRequest2);

        try {
            server.processServer("getStudentById", jsonRequestStudent3);
        } finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }
    }

    //6. Получить студентов по группе и получение по несуществующей группе
    @Test
    public void test_student_6() throws JsonProcessingException, ParseException {

        AddStudentGroupRequest groupRequest = new AddStudentGroupRequest("ММБ-104");
        ObjectWriter ow0 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestGroup = ow0.writeValueAsString(groupRequest);
        server.processServer("addStudentGroup", jsonRequestGroup);

        AddStudentRequest studentRequest1 = new AddStudentRequest("Котов", "Кот", "Котикович", "EXPELLED", "1");
        ObjectWriter ow1 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestStudent1 = ow1.writeValueAsString(studentRequest1);

        server.processServer("addStudent", jsonRequestStudent1);

        AddStudentRequest studentRequest2 = new AddStudentRequest("Собакен", "Собака", "Собакович", "ACADEMIC_LEAVE", "1");
        ObjectWriter ow2 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestStudent2 = ow2.writeValueAsString(studentRequest2);

        server.processServer("addStudent", jsonRequestStudent2);

        GetStudentsByGroupRequest getStudentsByGroupRequest = new GetStudentsByGroupRequest(1);
        ObjectWriter ow3 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequest = ow3.writeValueAsString(getStudentsByGroupRequest);
        String jsonResponse1 = server.processServer("getStudentsByGroup", jsonRequest);

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseEntity<GetStudentsByGroupResponse> response1 = objectMapper.readValue(jsonResponse1, new TypeReference<>() {
        });
        GetStudentsByGroupResponse objectResponse1 = response1.getResponseData();

        ArrayList<String> students = new ArrayList<>();
        DataBase dataBase = DataBase.getDataBase();
        Student student1 = dataBase.getStudentById(1);
        Student student2 = dataBase.getStudentById(2);
        students.add(student1.toString());
        students.add(student2.toString());

        Assert.assertEquals(students, objectResponse1.getListStudents());

        dataBase.clear();

    }

    //7. Поля empty, null, length > maxlength(50) и id<=0 и groupId<=0
    @Test
    public void test_student_7() throws JsonProcessingException, ParseException {
        EditStudentRequest editStudentRequest2 = new EditStudentRequest(-1, null, "аааааарараааааааааааааааааааааааааааааааааааааааааааааааааа", "", "STUDIES", "-5");
        ObjectWriter ow2 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestStudent2 = ow2.writeValueAsString(editStudentRequest2);

        try {
            server.processServer("editStudent", jsonRequestStudent2);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("[id<= 0, lastName is null, firstName exceeds the maximum length, middleName is empty, groupId<= 0]", e.getMessage());
        }
    }

    //8. Неккоректный статус
    @Test(expected = NullPointerException.class)
    public void test_student_8() throws JsonProcessingException, ParseException {
        AddStudentGroupRequest groupRequest = new AddStudentGroupRequest("ММБ-104");
        ObjectWriter ow0 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestGroup = ow0.writeValueAsString(groupRequest);
        server.processServer("addStudentGroup", jsonRequestGroup);

        AddStudentRequest studentRequest1 = new AddStudentRequest("Котов", "Кот", "Котикович", "FALSE", "1");
        ObjectWriter ow1 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestStudent1 = ow1.writeValueAsString(studentRequest1);

        try {
            server.processServer("addStudent", jsonRequestStudent1);
        }
        finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }
    }

    //9. Не найдена группа для добавления студента
    @Test(expected = NullPointerException.class)
    public void test_student_9() throws JsonProcessingException, ParseException {
        AddStudentRequest studentRequest1 = new AddStudentRequest("Котов", "Кот", "Котикович", "EXPELLED", "1");
        ObjectWriter ow1 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestStudent1 = ow1.writeValueAsString(studentRequest1);

        try {
            server.processServer("addStudent", jsonRequestStudent1);
        }
        finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }
    }

}
