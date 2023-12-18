package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.teacher.add.AddTeacherRequest;
import org.example.dto_request.teacher.delete.DeleteTeacherRequest;
import org.example.dto_request.teacher.edit.EditTeacherRequest;
import org.example.dto_request.teacher.get.GetTeacherByIdRequest;
import org.example.dto_response.teacher.GetTeacherByIdResponse;
import org.example.dto_response.teacher.GetTeachersResponse;
import org.example.model.Teacher;
import org.example.network_operations.ResponseEntity;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TeacherMethodsTest {

    Server server = new Server();

    //1. Добавление учителей - Получение всех учителей - Получение по ID
    @Test
    public void teacher_test1() throws Exception {
        try {
            AddTeacherRequest addTeacherRequest = new AddTeacherRequest("Котов", "Кот", "Котикович");
            ObjectWriter ow0 = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String jsonRequestTeacher = ow0.writeValueAsString(addTeacherRequest);
            server.processServer("addTeacher", jsonRequestTeacher);

            AddTeacherRequest addTeacherRequest2 = new AddTeacherRequest("Зайков", "Заяй", "Зайкович");
            ObjectWriter ow2 = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String jsonRequestTeacher2 = ow2.writeValueAsString(addTeacherRequest2);
            server.processServer("addTeacher", jsonRequestTeacher2);

            String result = server.processServer("getTeachers", null);
            ObjectMapper objectMapper = new ObjectMapper();
            ResponseEntity<GetTeachersResponse> response1 = objectMapper.readValue(result, new TypeReference<>() {
            });
            GetTeachersResponse objectResponse1 = response1.getResponseData();

            ArrayList<String> arrayList1 = objectResponse1.getListTeachers();

            Teacher teacher1 = new Teacher(1, "Кот", "Котикович", "Котов");
            Teacher teacher2 = new Teacher(2, "Заяй", "Зайкович", "Зайков");

            ArrayList<String> arrayList2 = new ArrayList<>();
            arrayList2.add(teacher1.toString());
            arrayList2.add(teacher2.toString());

            Assert.assertEquals(arrayList1, arrayList2);

            GetTeacherByIdRequest getTeacherByIdRequest = new GetTeacherByIdRequest(1);
            ObjectWriter ow3 = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String jsonRequestTeacher3 = ow3.writeValueAsString(getTeacherByIdRequest);
            String resultResponse = server.processServer("getTeacherById", jsonRequestTeacher3);

            ResponseEntity<GetTeacherByIdResponse> response2 = objectMapper.readValue(resultResponse, new TypeReference<>() {
            });
            GetTeacherByIdResponse objectResponse2 = response2.getResponseData();

            GetTeacherByIdResponse objectResponse3 = new GetTeacherByIdResponse("Кот", "Котов", "Котикович");

            Assert.assertEquals(objectResponse2, objectResponse3);
        } finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }
    }

    //2. Изменение данные - изменение несуществующего учителя
    @Test(expected = NullPointerException.class)
    public void teacher_test2() throws Exception {
        try {
            AddTeacherRequest addTeacherRequest = new AddTeacherRequest("Котов", "Кот", "Котикович");
            ObjectWriter ow0 = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String jsonRequestTeacher = ow0.writeValueAsString(addTeacherRequest);
            server.processServer("addTeacher", jsonRequestTeacher);

            EditTeacherRequest editTeacherRequest = new EditTeacherRequest(1, "Котиков", "Котофей", "Котикович");
            ObjectWriter ow1 = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String jsonRequestTeacher2 = ow1.writeValueAsString(editTeacherRequest);
            server.processServer("editTeacher", jsonRequestTeacher2);

            GetTeacherByIdRequest getTeacherByIdRequest = new GetTeacherByIdRequest(1);
            ObjectWriter ow3 = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String jsonRequestTeacher3 = ow3.writeValueAsString(getTeacherByIdRequest);
            String resultResponse = server.processServer("getTeacherById", jsonRequestTeacher3);

            ObjectMapper objectMapper = new ObjectMapper();
            ResponseEntity<GetTeacherByIdResponse> response1 = objectMapper.readValue(resultResponse, new TypeReference<>() {
            });
            GetTeacherByIdResponse objectResponse1 = response1.getResponseData();

            GetTeacherByIdResponse objectResponse2 = new GetTeacherByIdResponse("Котофей", "Котиков", "Котикович");

            Assert.assertEquals(objectResponse1, objectResponse2);

            EditTeacherRequest editTeacherRequest2 = new EditTeacherRequest(10, "Котиков", "Котофей", "Котикович");
            ObjectWriter ow2 = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String jsonRequestTeacher22 = ow2.writeValueAsString(editTeacherRequest2);

            server.processServer("editTeacher", jsonRequestTeacher22);
        } finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }
    }

    //3. Удаление учителя - удаление несуществующего учителя
    @Test
    public void teacher_test3() throws Exception {
        try {
            AddTeacherRequest addTeacherRequest = new AddTeacherRequest("Котов", "Кот", "Котикович");
            ObjectWriter ow0 = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String jsonRequestTeacher = ow0.writeValueAsString(addTeacherRequest);
            server.processServer("addTeacher", jsonRequestTeacher);

            DeleteTeacherRequest deleteTeacherRequest = new DeleteTeacherRequest(1);
            ObjectWriter ow1 = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String jsonRequestTeacher2 = ow1.writeValueAsString(deleteTeacherRequest);
            String result = server.processServer("deleteTeacher", jsonRequestTeacher2);

            ObjectMapper objectMapper = new ObjectMapper();
            ResponseEntity<String> response1 = objectMapper.readValue(result, new TypeReference<>() {
            });
            String objectResponse1 = response1.getResponseData();

            Assert.assertEquals(objectResponse1, "Преподаватель удален");

            server.processServer("deleteTeacher", jsonRequestTeacher2);
        } catch (NullPointerException e) {
            Assert.assertEquals(e.getMessage(), "Такой преподаватель не найден");
        } finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }
    }

    //4. Получить несуществующий по ID
    @Test(expected = NullPointerException.class)
    public void teacher_test4() throws Exception {
        try {
            GetTeacherByIdRequest getTeacherByIdRequest = new GetTeacherByIdRequest(1);
            ObjectWriter ow3 = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String jsonRequestTeacher3 = ow3.writeValueAsString(getTeacherByIdRequest);

            server.processServer("getTeacherById", jsonRequestTeacher3);
        } finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }
    }

    //5. Валидация
    @Test
    public void teacher_test5() throws Exception {
        AddTeacherRequest addTeacherRequest = new AddTeacherRequest("", null, "аааааарараааааааааааааааааааааааааааааааааааааааааааааааааа");
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestStudent = ow.writeValueAsString(addTeacherRequest);

        try {
            server.processServer("addTeacher", jsonRequestStudent);
        } catch (Exception e) {
            Assert.assertEquals("[lastName is empty, firstName is null, middleName exceeds the maximum length]", e.getMessage());
        }
    }
}
