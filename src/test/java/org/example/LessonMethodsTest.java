package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import java.text.ParseException;

public class LessonMethodsTest {

    Server server = new Server();

    @Test
    public void addLesson() throws JsonProcessingException, ParseException {

//        AddLessonRequest request = new AddLessonRequest("2012-12-10",1,1,1);
//
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String jsonRequest = ow.writeValueAsString(request);
//        String jsonResponse = server.processServer("addLesson",jsonRequest);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        ResponseEntity<AddLessonResponse> response = objectMapper.readValue(jsonResponse, new TypeReference<>() {});
//        AddLessonResponse response1 = response.getResponseData();
//
//        AddLessonResponse response2= new AddLessonResponse(5);
//
//        Assert.assertEquals(response1,response2);
    }

    @Test
    public void editLesson() throws JsonProcessingException, ParseException {
//        EditLessonRequest request = new EditLessonRequest(5,"2012-12-10",1,1,1);
//
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String jsonRequest = ow.writeValueAsString(request);
//        String jsonResponse = server.processServer("editLesson",jsonRequest);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        ResponseEntity<EditLessonResponse> response = objectMapper.readValue(jsonResponse, new TypeReference<>() {});
//        EditLessonResponse response1 = response.getResponseData();
//
//        EditLessonResponse response2 = new EditLessonResponse("2012-12-10",1,1,1);
//
//        Assert.assertEquals(response1,response2);
    }

    @Test
    public void getLessonById() throws JsonProcessingException, ParseException {
//        GetLessonByIdRequest request = new GetLessonByIdRequest(6);
//
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String jsonRequest = ow.writeValueAsString(request);
//        String jsonResponse = server.processServer("getLessonById",jsonRequest);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        ResponseEntity<GetLessonByIdResponse> response = objectMapper.readValue(jsonResponse, new TypeReference<>() {});
//        GetLessonByIdResponse response1 = response.getResponseData();
//
//        StatusStudent status = StatusStudent.EXPELLED;
//        StudentGroup group = new StudentGroup(8,"МИТ-16");
//        Student student1 = new Student(3,"Иванов","Иван","Иванович",status,group);
//        Student student2 = new Student(4,"Иванова","Ивана","Ивановна",status,group);
//
//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add(student1.toString());
//        arrayList.add(student2.toString());

    }

    @Test
    public void getLessonsByGroup() throws JsonProcessingException, ParseException {

//        GetLessonsByGroupRequest request = new GetLessonsByGroupRequest("2015-12-10","2015-12-12",8);
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String jsonRequest = ow.writeValueAsString(request);
//        String jsonResponse = server.processServer("getLessonsByGroup",jsonRequest);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        ResponseEntity<GetLessonsByGroupResponse> response = objectMapper.readValue(jsonResponse, new TypeReference<>() {});
//        GetLessonsByGroupResponse response1 = response.getResponseData();
//
//        Teacher teacher = new Teacher(19,"Анастасия","Алексеевна","Рубко");
//        StudentGroup group = new StudentGroup(8,"МИТ-16");
        //Lesson lesson1 = new Lesson(1,"2015-12-12",2,teacher,group);
        //Lesson lesson2 = new Lesson(2,"2015-12-12",3,teacher,group);
        //ArrayList<String> lessons = new ArrayList<>();
        //lessons.add(lesson1.toString());
        // lessons.add(lesson2.toString());

        // GetLessonsByGroupResponse response2 = new GetLessonsByGroupResponse(lessons);

        //Assert.assertEquals(response1,response2);
    }

    @Test
    public void getLessonsByTeacher() throws JsonProcessingException, ParseException {

//        GetLessonsByTeacherRequest request = new GetLessonsByTeacherRequest("2015-12-10","2015-12-12",29);
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String jsonRequest = ow.writeValueAsString(request);
//        String jsonResponse = server.processServer("getLessonsByTeacher",jsonRequest);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        ResponseEntity<GetLessonsByTeacherResponse> response = objectMapper.readValue(jsonResponse, new TypeReference<>() {});
//        GetLessonsByTeacherResponse response1 = response.getResponseData();
//
//
//        Teacher teacher = new Teacher(29,"Анастасия","Алексеевна","Рубко");
//        StudentGroup group = new StudentGroup(8,"МИТ-16");
        //Lesson lesson1 = new Lesson(1,"2015-12-12",2,teacher,group);
        //Lesson lesson2 = new Lesson(2,"2015-12-12",3,teacher,group);
        //ArrayList<String> lessons = new ArrayList<>();
        //lessons.add(lesson1.toString());
        //lessons.add(lesson2.toString());

        // GetLessonsByTeacherResponse response2 = new GetLessonsByTeacherResponse(lessons);

        //Assert.assertEquals(response1,response2);
    }

}
