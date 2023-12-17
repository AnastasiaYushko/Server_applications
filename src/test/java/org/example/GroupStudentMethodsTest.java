package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import java.text.ParseException;

public class GroupStudentMethodsTest {

    Server server = new Server();
    @Test
    public void deleteStudentGroup() throws JsonProcessingException, ParseException {
//        DeleteStudentGroupRequest object = new DeleteStudentGroupRequest(1);
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String jsonRequest = ow.writeValueAsString(object);
//        String jsonResponse = server.processServer("deleteStudentGroup",jsonRequest);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        ResponseEntity<String> response =  objectMapper.readValue(jsonResponse, new TypeReference<>() {});
//
//        String responseString = response.getResponseData();
//
//        Assert.assertEquals(responseString,"Ответ сервера на метод deleteStudentGroup");
    }

    @Test
    public void addStudentGroup() throws JsonProcessingException, ParseException {
//
//        AddStudentGroupRequest object = new AddStudentGroupRequest("КТИ-01");
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String jsonRequest = ow.writeValueAsString(object);
//        String jsonResponse = server.processServer("addStudentGroup",jsonRequest);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        ResponseEntity<AddStudentGroupResponse> response =  objectMapper.readValue(jsonResponse, new TypeReference<>() {});
//        AddStudentGroupResponse response1 = response.getResponseData();
//
//        AddStudentGroupResponse response2 = new AddStudentGroupResponse(1);
//
//        Assert.assertEquals(response1,response2);
    }

    @Test
    public void getStudentGroups() throws JsonProcessingException, ParseException {

//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String jsonRequest = ow.writeValueAsString("");
//        String jsonResponse = server.processServer("getStudentGroups",jsonRequest);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        ResponseEntity<GetStudentGroupsResponse> response =  objectMapper.readValue(jsonResponse, new TypeReference<>() {});
//        GetStudentGroupsResponse response1 = response.getResponseData();
//
//        StudentGroup group1 = new StudentGroup(1,"ППП-01");
//        StudentGroup group2 = new StudentGroup(2,"ТИ-02");
//        ArrayList<String> listStudentGroup= new ArrayList<>();
//        listStudentGroup.add(group1.toString());
//        listStudentGroup.add(group2.toString());
//
//        GetStudentGroupsResponse response2 = new GetStudentGroupsResponse(listStudentGroup);
//
//        Assert.assertEquals(response1,response2);

    }

    @Test
    public void editStudentGroup() throws JsonProcessingException, ParseException {

//        EditStudentGroupRequest object = new EditStudentGroupRequest(5,"КТИ-01");
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String jsonRequest = ow.writeValueAsString(object);
//        String jsonResponse = server.processServer("editStudentGroup",jsonRequest);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        ResponseEntity<EditStudentGroupResponse> response =  objectMapper.readValue(jsonResponse, new TypeReference<>() {});
//        EditStudentGroupResponse response1 = response.getResponseData();
//
//        EditStudentGroupResponse response2 = new EditStudentGroupResponse("КТИ-01");
//
//        Assert.assertEquals(response1,response2);
    }

    @Test
    public void getStudentGroupById() throws JsonProcessingException, ParseException {
//        GetStudentGroupByIdRequest object = new GetStudentGroupByIdRequest(1);
//
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String jsonRequest = ow.writeValueAsString(object);
//        String jsonResponse = server.processServer("getStudentGroupById",jsonRequest);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        ResponseEntity<GetStudentGroupByIdResponse> response =  objectMapper.readValue(jsonResponse, new TypeReference<>() {});
//        GetStudentGroupByIdResponse response1 = response.getResponseData();
//
//        GetStudentGroupByIdResponse response2 = new GetStudentGroupByIdResponse("ММБ-104");
//
//        Assert.assertEquals(response1,response2);

    }
}
