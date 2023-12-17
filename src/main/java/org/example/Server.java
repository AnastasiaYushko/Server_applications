package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.handler.IHandler;
import org.example.handler.lesson.*;
import org.example.handler.lessonVisiting.AddLessonVisitingHandler;
import org.example.handler.lessonVisiting.DeleteLessonVisitingHandler;
import org.example.handler.lessonVisiting.GetLessonVisitingHandler;
import org.example.handler.student.*;
import org.example.handler.studentGroup.*;
import org.example.handler.subject.*;
import org.example.handler.teacher.*;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private final static Map<String, IHandler> map = new HashMap<>();

    static {
        map.put("getStudentById", new GetStudentByIdHandler());
        map.put("addStudent", new AddStudentHandler());
        map.put("editStudent", new EditStudentHandler());
        map.put("deleteStudent", new DeleteStudentHandler());
        map.put("getStudentsByGroup", new GetStudentsByGroupHandler());

        map.put("getStudentGroups", new GetStudentGroupsHandler());
        map.put("getStudentGroupById", new GetStudentGroupByIdHandler());
        map.put("addStudentGroup", new AddStudentGroupHandler());
        map.put("editStudentGroup", new EditStudentGroupHandler());
        map.put("deleteStudentGroup", new DeleteStudentGroupHandler());

        map.put("getTeachers", new GetTeachersHandler());
        map.put("getTeacherById", new GetTeacherByIdHandler());
        map.put("addTeacher", new AddTeacherHandler());
        map.put("editTeacher", new EditTeacherHandler());
        map.put("deleteTeacher", new DeleteTeacherHandler());

        map.put("getSubjects", new GetSubjectsHandler());
        map.put("getSubjectById", new GetSubjectByIdHandler());
        map.put("addSubject", new AddSubjectHandler());
        map.put("deleteSubject", new DeleteSubjectHandler());
        map.put("editSubject", new EditSubjectHandler());

        map.put("addLesson", new AddLessonHandler());
        map.put("editLesson", new EditLessonHandler());
        map.put("getLessonById", new GetLessonByIdHandler());
        map.put("getLessonsByGroup", new GetLessonsByGroupHandler());
        map.put("getLessonsByTeacher", new GetLessonByTeacherHandler());

        map.put("getLessonVisiting", new GetLessonVisitingHandler());
        map.put("addLessonVisiting", new AddLessonVisitingHandler());
        map.put("deleteLessonVisiting", new DeleteLessonVisitingHandler());

    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public String processServer(String endpoint, String json) throws JsonProcessingException, ParseException {

        IHandler classHandler = map.get(endpoint);
        return classHandler.handler(json);
    }
}