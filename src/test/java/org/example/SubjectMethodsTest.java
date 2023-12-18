package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.subject.add.AddSubjectRequest;
import org.example.dto_request.subject.delete.DeleteSubjectRequest;
import org.example.dto_request.subject.edit.EditSubjectRequest;
import org.example.dto_request.subject.get.GetSubjectByIdRequest;
import org.example.dto_response.subject.AddSubjectResponse;
import org.example.dto_response.subject.GetSubjectByIdResponse;
import org.example.dto_response.subject.GetSubjectsResponse;
import org.example.model.Subject;
import org.example.network_operations.ResponseEntity;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class SubjectMethodsTest {

    Server server = new Server();

    //1. Добавление предметов - получить все предметы
    @Test
    public void subject_test1() throws Exception {
        try {
            AddSubjectRequest addSubjectRequest = new AddSubjectRequest("Математика");
            ObjectWriter ow0 = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String jsonRequestSubject = ow0.writeValueAsString(addSubjectRequest);
            server.processServer("addSubject", jsonRequestSubject);

            AddSubjectRequest addSubjectRequest2 = new AddSubjectRequest("Информатика");
            ObjectWriter ow2 = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String jsonRequestSubject2 = ow2.writeValueAsString(addSubjectRequest2);
            String responseResult = server.processServer("addSubject", jsonRequestSubject2);

            ObjectMapper objectMapper = new ObjectMapper();
            ResponseEntity<AddSubjectResponse> response1 = objectMapper.readValue(responseResult, new TypeReference<>() {
            });
            AddSubjectResponse objectResponse1 = response1.getResponseData();

            AddSubjectResponse objectResponse2 = new AddSubjectResponse(2);

            Assert.assertEquals(objectResponse1, objectResponse2);

            String responseResult2 = server.processServer("getSubjects", null);
            ResponseEntity<GetSubjectsResponse> response2 = objectMapper.readValue(responseResult2, new TypeReference<>() {
            });
            GetSubjectsResponse objectResponse3 = response2.getResponseData();

            ArrayList<String> arrayList1 = objectResponse3.getListSubjects();

            Subject subject1 = new Subject(1, "Математика");
            Subject subject2 = new Subject(2, "Информатика");

            ArrayList<String> arrayList2 = new ArrayList<>();
            arrayList2.add(subject1.toString());
            arrayList2.add(subject2.toString());

            Assert.assertEquals(arrayList1, arrayList2);
        } finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }

    }

    //2. Получить по ID  - удаление - удаление несуществующего
    @Test
    public void subject_test2() throws Exception {
        try {
            AddSubjectRequest addSubjectRequest = new AddSubjectRequest("Математика");
            ObjectWriter ow0 = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String jsonRequestSubject = ow0.writeValueAsString(addSubjectRequest);
            server.processServer("addSubject", jsonRequestSubject);

            GetSubjectByIdRequest getSubjectByIdRequest = new GetSubjectByIdRequest(1);
            ObjectWriter ow1 = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String jsonRequestSubject1 = ow1.writeValueAsString(getSubjectByIdRequest);
            String response = server.processServer("getSubjectById", jsonRequestSubject1);

            ObjectMapper objectMapper = new ObjectMapper();
            ResponseEntity<GetSubjectByIdResponse> response1 = objectMapper.readValue(response, new TypeReference<>() {
            });
            GetSubjectByIdResponse objectResponse1 = response1.getResponseData();

            GetSubjectByIdResponse objectResponse2 = new GetSubjectByIdResponse("Математика");

            Assert.assertEquals(objectResponse1, objectResponse2);

            DeleteSubjectRequest deleteSubjectRequest = new DeleteSubjectRequest(1);
            ObjectWriter ow01 = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String jsonRequestSubject2 = ow01.writeValueAsString(deleteSubjectRequest);
            String responseResult = server.processServer("deleteSubject", jsonRequestSubject2);
            ResponseEntity<String> response12 = objectMapper.readValue(responseResult, new TypeReference<>() {
            });
            String objectResponse12 = response12.getResponseData();

            Assert.assertEquals(objectResponse12, "Предмет удален");

            server.processServer("deleteSubject", jsonRequestSubject2);
        } catch (NullPointerException e) {
            Assert.assertEquals(e.getMessage(), "Такой предмет не найден в системе");
        } finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }
    }

    //3 Получить все если нет - получить по ID несуществующий предмет
    @Test
    public void subject_test3() throws Exception {

        try {
            String response = server.processServer("getSubjects", null);
            ObjectMapper objectMapper = new ObjectMapper();
            ResponseEntity<GetSubjectsResponse> response1 = objectMapper.readValue(response, new TypeReference<>() {
            });
            GetSubjectsResponse responseResult = response1.getResponseData();

            ArrayList<String> arrayList1 = responseResult.getListSubjects();

            ArrayList<String> arrayList2 = new ArrayList<>();

            Assert.assertEquals(arrayList1, arrayList2);

            GetSubjectByIdRequest getSubjectByIdRequest = new GetSubjectByIdRequest(10);
            ObjectWriter ow0 = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String jsonRequestSubject = ow0.writeValueAsString(getSubjectByIdRequest);

            server.processServer("getSubjectById", jsonRequestSubject);
        } catch (NullPointerException e) {
            Assert.assertEquals(e.getMessage(), "Такого предмета не найдено");
        } finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }
    }

    //4. Изменение предмета и изменение несуществующего предмета
    @Test
    public void subject_test4() throws Exception {
        try {
            AddSubjectRequest addSubjectRequest = new AddSubjectRequest("Математика");
            ObjectWriter ow0 = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String jsonRequestSubject = ow0.writeValueAsString(addSubjectRequest);
            server.processServer("addSubject", jsonRequestSubject);

            EditSubjectRequest editSubjectRequest = new EditSubjectRequest(1, "Математика");
            ObjectWriter ow1 = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String jsonRequestSubject1 = ow1.writeValueAsString(editSubjectRequest);
            String response = server.processServer("editSubject", jsonRequestSubject1);
            ObjectMapper objectMapper = new ObjectMapper();
            ResponseEntity<String> response1 = objectMapper.readValue(response, new TypeReference<>() {
            });
            String objectResponse1 = response1.getResponseData();

            Assert.assertEquals(objectResponse1, "Предмет изменен");

            EditSubjectRequest editSubjectRequest2 = new EditSubjectRequest(15, "Биология");
            ObjectWriter ow2 = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String jsonRequestSubject2 = ow2.writeValueAsString(editSubjectRequest2);

            server.processServer("editSubject", jsonRequestSubject2);
        } catch (NullPointerException e) {
            Assert.assertEquals("Такой предмет не найден в системе", e.getMessage());
        } finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }
    }

    //5. Валидация string - is null
    @Test
    public void subject_test5() throws Exception {
        AddSubjectRequest addSubjectRequest = new AddSubjectRequest(null);
        ObjectWriter ow0 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestSubject = ow0.writeValueAsString(addSubjectRequest);

        try {
            server.processServer("addSubject", jsonRequestSubject);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "[name is null]");
        } finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }
    }

}
