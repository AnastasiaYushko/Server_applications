package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.dto_request.lessonVisiting.add.AddLessonVisitingRequest;
import org.example.enums.StatusStudent;
import org.example.model.Student;
import org.example.model.StudentGroup;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;

public class LessonVisitingMethodsTest {

    Server server = new Server();

    // 1. Добавить посещаемость - получить посещаеемость по ID урока - удалить посещаемость - получить по несуществующему уроку
    // если нет посещаемости?
    @Test
    public void lessonVisiting_test1() throws JsonProcessingException, ParseException {
        StudentGroup studentGroup = new StudentGroup(1, "ММБ-102");
        StatusStudent statusStudent = StatusStudent.STUDIES;
        Student student1 = new Student(1, "Филиппов", "Илья", "Иванович", statusStudent, studentGroup);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(student1.toString());
        AddLessonVisitingRequest addLessonVisitingRequest = new AddLessonVisitingRequest(1, arrayList);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestLessonVisiting = ow.writeValueAsString(addLessonVisitingRequest);

        try {
            server.processServer("addLessonVisiting", jsonRequestLessonVisiting);
        }
        catch (NullPointerException e){
            Assert.assertEquals(e.getMessage(),"Такого урока нет в системе");
        }
        finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }
    }

    //2. Добавить к несуществующему уроку
    @Test
    public void lessonVisiting_test2() throws JsonProcessingException, ParseException {
        StudentGroup studentGroup = new StudentGroup(1,"ММБ-102");
        StatusStudent statusStudent = StatusStudent.STUDIES;
        Student student1 = new Student(1,"Филиппов","Илья","Иванович",statusStudent,studentGroup);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(student1.toString());
        AddLessonVisitingRequest addLessonVisitingRequest = new AddLessonVisitingRequest(1,arrayList);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestLessonVisiting = ow.writeValueAsString(addLessonVisitingRequest);

        try {
            server.processServer("addLessonVisiting", jsonRequestLessonVisiting);
        } catch (NullPointerException e) {
            Assert.assertEquals(e.getMessage(),"Такого урока нет в системе");
        } finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }
    }

    //3. Удалить по несуществующему уроку
   /* @Test
    public void lessonVisiting_test3() throws JsonProcessingException, ParseException {
        DeleteLessonByIdRequest deleteLessonByIdRequest = new DeleteLessonByIdRequest(1);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonRequestLessonVisiting = ow.writeValueAsString(deleteLessonByIdRequest);

        try {
            server.processServer("deleteLessonVisiting", jsonRequestLessonVisiting);
        } catch (NullPointerException e) {
            Assert.assertEquals(e.getMessage(),"Данных о посещаемости такого урока нет в система");
        } finally {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.clear();
        }
    }*/
}
