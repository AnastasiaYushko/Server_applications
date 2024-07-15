/*
package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.studentGroup.add.AddStudentGroupRequest;
import org.example.dto_request.studentGroup.delete.DeleteStudentGroupRequest;
import org.example.dto_request.studentGroup.edit.EditStudentGroupRequest;
import org.example.dto_request.studentGroup.get.GetStudentGroupByIdRequest;
import org.example.dto_response.studentGroup.GetStudentGroupByIdResponse;
import org.example.dto_response.studentGroup.GetStudentGroupsResponse;
import org.example.model.StudentGroup;
import org.example.network_operations.ResponseEntity;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;

public class GroupStudentMethodsTest {

    Server server = new Server();

    //0. Ошибка в методе
    @Test
    public void test_0() throws JsonProcessingException,ParseException{
        try{
            AddStudentGroupRequest groupRequest = new AddStudentGroupRequest("ММБ-104");
            ObjectWriter ow0 = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String jsonRequestGroup = ow0.writeValueAsString(groupRequest);
            server.processServer("addGroup", jsonRequestGroup);
        }
        catch (NullPointerException e){
            Assert.assertEquals(e.getMessage(),"Метод не найден");
        }
    }


    //1. Добавление групп - получить все группы - удалить - получить если нет - удалить несуществующую
    @Test
    public void studentGroup_test_1() throws JsonProcessingException, ParseException {
        AddStudentGroupRequest groupRequest = new AddStudentGroupRequest("ММБ-104");
        ObjectWriter ow0 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestGroup = ow0.writeValueAsString(groupRequest);
        server.processServer("addStudentGroup", jsonRequestGroup);

        AddStudentGroupRequest groupRequest1 = new AddStudentGroupRequest("ММБ-103");
        ObjectWriter ow1 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestGroup1 = ow1.writeValueAsString(groupRequest1);
        server.processServer("addStudentGroup", jsonRequestGroup1);

        String result = server.processServer("getStudentGroups", null);
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseEntity<GetStudentGroupsResponse> response = objectMapper.readValue(result, new TypeReference<>() {
        });

        GetStudentGroupsResponse getStudentGroupsResponse = response.getResponseData();

        ArrayList<String> arrayList1 = getStudentGroupsResponse.getGroups();
        ArrayList<String> arrayList2 = new ArrayList<>();
        DataBase dataBase = DataBase.getDataBase();
        arrayList2.add(dataBase.getStudentGroupById(1).toString());
        arrayList2.add(dataBase.getStudentGroupById(2).toString());

        Assert.assertEquals(arrayList1, arrayList2);

        DeleteStudentGroupRequest deleteStudentGroupRequest = new DeleteStudentGroupRequest(1);
        ObjectWriter ow2 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestGroup2 = ow2.writeValueAsString(deleteStudentGroupRequest);
        server.processServer("deleteStudentGroup", jsonRequestGroup2);

        DeleteStudentGroupRequest deleteStudentGroupRequest2 = new DeleteStudentGroupRequest(2);
        ObjectWriter ow3 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestGroup3 = ow3.writeValueAsString(deleteStudentGroupRequest2);
        String resultDelete = server.processServer("deleteStudentGroup", jsonRequestGroup3);
        ResponseEntity<String> responseDelete = objectMapper.readValue(resultDelete, new TypeReference<>() {
        });

        String responseStringDelete = responseDelete.getResponseData();

        Assert.assertEquals(responseStringDelete, "Группа удалена");

        String jsonResult = server.processServer("getStudentGroups", null);
        ResponseEntity<GetStudentGroupsResponse> responseResult = objectMapper.readValue(jsonResult, new TypeReference<>() {
        });

        GetStudentGroupsResponse getStudentGroupsResponse2 = responseResult.getResponseData();

        ArrayList<String> arrayListResult = getStudentGroupsResponse2.getGroups();
        arrayList2.clear();

        Assert.assertEquals(arrayListResult, arrayList2);

        DeleteStudentGroupRequest deleteStudentGroupRequest3 = new DeleteStudentGroupRequest(2);
        ObjectWriter ow4 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestGroup4 = ow4.writeValueAsString(deleteStudentGroupRequest3);

        try {
            server.processServer("deleteStudentGroup", jsonRequestGroup4);
        } catch (NullPointerException e) {
            Assert.assertEquals(e.getMessage(),"Такой группы нет в системе");
        } finally {
            dataBase.clear();
        }
    }

    //2. Изменение группы и изменение несуществующей группы
    @Test
    public void studentGroup_test_2() throws JsonProcessingException, ParseException {
        AddStudentGroupRequest groupRequest = new AddStudentGroupRequest("ММБ-104");
        ObjectWriter ow0 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestGroup = ow0.writeValueAsString(groupRequest);
        server.processServer("addStudentGroup", jsonRequestGroup);

        EditStudentGroupRequest editStudentGroupRequest = new EditStudentGroupRequest(1, "МПБ-103");
        ObjectWriter ow1 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestGroupEdit = ow1.writeValueAsString(editStudentGroupRequest);
        server.processServer("editStudentGroup", jsonRequestGroupEdit);

        DataBase dataBase = DataBase.getDataBase();
        StudentGroup group = dataBase.getStudentGroupById(1);
        StudentGroup group2 = new StudentGroup(1, "МПБ-103");

        Assert.assertEquals(group2, group);

        EditStudentGroupRequest editStudentGroupRequest2 = new EditStudentGroupRequest(5, "МПБ-116");
        ObjectWriter ow2 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestGroupEdit2 = ow2.writeValueAsString(editStudentGroupRequest2);

        try {
            server.processServer("editStudentGroup", jsonRequestGroupEdit2);
        } catch (NullPointerException e) {
            Assert.assertEquals(e.getMessage(),"Такой группы нет в системе");
        } finally {
            dataBase.clear();
        }
    }

    //3. Получение группы по id и получение несуществующей
    @Test
    public void studentGroup_test_3() throws JsonProcessingException, ParseException {
        AddStudentGroupRequest groupRequest = new AddStudentGroupRequest("ММБ-104");
        ObjectWriter ow0 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestGroup = ow0.writeValueAsString(groupRequest);
        server.processServer("addStudentGroup", jsonRequestGroup);

        GetStudentGroupByIdRequest getStudentGroupByIdRequest = new GetStudentGroupByIdRequest(1);
        ObjectWriter ow1 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestGroup1 = ow1.writeValueAsString(getStudentGroupByIdRequest);
        String jsonResponse = server.processServer("getStudentGroupById", jsonRequestGroup1);

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseEntity<GetStudentGroupByIdResponse> response = objectMapper.readValue(jsonResponse, new TypeReference<>() {
        });

        GetStudentGroupByIdResponse getStudentGroupResponse = response.getResponseData();
        GetStudentGroupByIdResponse okResponse = new GetStudentGroupByIdResponse("ММБ-104");

        Assert.assertEquals(getStudentGroupResponse, okResponse);

        GetStudentGroupByIdRequest getStudentGroupByIdRequest2 = new GetStudentGroupByIdRequest(10);
        ObjectWriter ow2 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestGroup2 = ow2.writeValueAsString(getStudentGroupByIdRequest2);

        try {
            server.processServer("getStudentGroupById", jsonRequestGroup2);
        } catch (NullPointerException e) {
            Assert.assertEquals(e.getMessage(),"Такой группы нет в системе");
        } finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }
    }

    //4. Валидация string - is empty
    @Test
    public void studentGroup_test_4() throws JsonProcessingException, ParseException {
        AddStudentGroupRequest addStudentGroupRequest = new AddStudentGroupRequest("");
        ObjectWriter ow0 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestGroup = ow0.writeValueAsString(addStudentGroupRequest);

        try {
            server.processServer("addStudentGroup", jsonRequestGroup);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "[name is empty]");
        }
        finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }
    }

    //5. Валидация string - is null
    @Test
    public void studentGroup_test_5() throws JsonProcessingException, ParseException {
        AddStudentGroupRequest addStudentGroupRequest = new AddStudentGroupRequest(null);
        ObjectWriter ow0 = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestGroup = ow0.writeValueAsString(addStudentGroupRequest);

        try {
            server.processServer("addStudentGroup", jsonRequestGroup);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "[name is null]");
        } finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }
    }

    //6. Валидация - big length
    @Test
    public void studentGroup_test_6() throws JsonProcessingException, ParseException {
        AddStudentGroupRequest addStudentGroupRequest = new AddStudentGroupRequest("fffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestGroup = ow.writeValueAsString(addStudentGroupRequest);

        try {
            server.processServer("addStudentGroup", jsonRequestGroup);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "[name exceeds the maximum length]");
        } finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }
    }
}
*/