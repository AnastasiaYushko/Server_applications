package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import java.text.ParseException;

public class StudentMethodsTest {

    Server server = new Server();
    @Test
    public void addStudent() throws JsonProcessingException, ParseException {

//        StatusStudent studentStatus = StatusStudent.EXPELLED;
//        AddStudentRequest object = new AddStudentRequest("Егоров","Илья","Александрович",studentStatus.toString(),"1");
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String jsonRequest = ow.writeValueAsString(object);
//        String jsonResponse = server.processServer("addStudent",jsonRequest);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        ResponseEntity<AddStudentResponse> response = objectMapper.readValue(jsonResponse, new TypeReference<>() {});
//        AddStudentResponse objectResponse1 = response.getResponseData();
//
//        AddStudentResponse objectResponse2 = new AddStudentResponse(1);
//
//        Assert.assertEquals(objectResponse1, objectResponse2);

    }

    @Test
    public void deleteStudent() throws JsonProcessingException, ParseException {

//        DeleteStudentRequest object = new DeleteStudentRequest(1);
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String jsonRequest = ow.writeValueAsString(object);
//        String jsonResponse = server.processServer("deleteStudent",jsonRequest);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        ResponseEntity<String> response =  objectMapper.readValue(jsonResponse, new TypeReference<>() {});
//
//        String responseString = response.getResponseData();
//
//        Assert.assertEquals(responseString,"Ответ сервера на метод deleteStudent");
    }

    @Test
    public void getStudentById() throws JsonProcessingException, ParseException {

//        GetStudentByIdRequest object = new GetStudentByIdRequest(1);
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String jsonRequest = ow.writeValueAsString(object);
//        String jsonResponse = server.processServer("getStudentById",jsonRequest);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        ResponseEntity<GetStudentByIdResponse> response =  objectMapper.readValue(jsonResponse, new TypeReference<>() {});
//
//        GetStudentByIdResponse response1 = response.getResponseData();
//
//        StatusStudent studentStatus = StatusStudent.STUDIES;
//        StudentGroup studentGroup = new StudentGroup(1,"ММБ-104");
//        GetStudentByIdResponse response2 = new GetStudentByIdResponse("Калинин","Иван","Пураванович",studentStatus.toString(),studentGroup.toString());
//
//        Assert.assertEquals(response1,response2);
    }

    @Test
    public void getStudentsByGroup() throws JsonProcessingException, ParseException {

//        GetStudentsByGroupRequest object = new GetStudentsByGroupRequest(1);
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String jsonRequest = ow.writeValueAsString(object);
//        String jsonResponse = server.processServer("getStudentsByGroup",jsonRequest);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        ResponseEntity<GetStudentsByGroupResponse> response =  objectMapper.readValue(jsonResponse, new TypeReference<>() {});
//
//        GetStudentsByGroupResponse response1 = response.getResponseData();
//
//        StatusStudent studentStatus = StatusStudent.ACADEMIC_LEAVE;
//        StudentGroup studentGroup = new StudentGroup(1,"ММБ-104");
//        Student student1 = new Student(1,"Попов","Алексей","Валерьевич",studentStatus,studentGroup);
//        Student student2 = new Student(2,"Попова","Валерия","Валерьевна",studentStatus,studentGroup);
//        ArrayList<String> listStudent = new ArrayList<>();
//        listStudent.add(student1.toString());
//        listStudent.add(student2.toString());
//
//        GetStudentsByGroupResponse response2 = new GetStudentsByGroupResponse(listStudent);
//
//        Assert.assertEquals(response1,response2);
    }

    @Test
    public void editStudent() throws JsonProcessingException, ParseException {

//        StatusStudent studentStatus = StatusStudent.ACADEMIC_LEAVE;
//        StudentGroup studentGroup = new StudentGroup(66,"КИИ-189");
//        EditStudentRequest object = new EditStudentRequest(1,"Попов","Арсений","Евгеньевич",studentStatus.toString(),studentGroup.toString());
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String jsonRequest = ow.writeValueAsString(object);
//        String jsonResponse = server.processServer("editStudent",jsonRequest);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        ResponseEntity<EditStudentResponse> response =  objectMapper.readValue(jsonResponse, new TypeReference<>() {});
//
//        EditStudentResponse response1 = response.getResponseData();
//
//        EditStudentResponse response2 = new EditStudentResponse("Попов","Арсений","Евгеньевич",studentStatus.toString(),studentGroup.toString());
//
//        Assert.assertEquals(response1,response2);
    }
}
