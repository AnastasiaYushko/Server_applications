package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import java.text.ParseException;

public class LessonVisitingMethodsTest {

    Server server = new Server();

    @Test
    public void getLessonVisiting() throws JsonProcessingException, ParseException {

//        GetLessonVisitingRequest request = new GetLessonVisitingRequest(1);
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String jsonRequest = ow.writeValueAsString(request);
//        String jsonResponse = server.processServer("getLessonVisiting",jsonRequest);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        ResponseEntity<GetLessonVisitingResponse> response =  objectMapper.readValue(jsonResponse, new TypeReference<>() {});
//        GetLessonVisitingResponse response1 = response.getResponseData();
//
//        StatusStudent studentStatus = StatusStudent.ACADEMIC_LEAVE;
//        StudentGroup studentGroup = new StudentGroup(1,"ММБ-104");
//        Student student1 = new Student(1,"Попов","Алексей","Валерьевич",studentStatus,studentGroup);
//        Student student2 = new Student(2,"Попова","Валерия","Валерьевна",studentStatus,studentGroup);
//        ArrayList<Student> listStudent = new ArrayList<>();
//        listStudent.add(student1);
//        listStudent.add(student2);
//
//        LessonVisiting lessonVisiting = new LessonVisiting(1,2,listStudent);
//
//        GetLessonVisitingResponse response2 = new GetLessonVisitingResponse(lessonVisiting.toString());
//
//        Assert.assertEquals(response1,response2);
    }
}
