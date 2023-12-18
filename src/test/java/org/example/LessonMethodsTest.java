package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import java.text.ParseException;

public class LessonMethodsTest {

    Server server = new Server();

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
