package org.example.services.serviceInterfaceImpl;

import org.example.dao_repositories_implements.LessonDAOImpl;
import org.example.dto_request.lesson.add.AddLessonRequest;
import org.example.dto_request.lesson.delete.byGroup.DeleteLessonsByGroupRequest;
import org.example.dto_request.lesson.delete.byId.DeleteLessonByIdRequest;
import org.example.dto_request.lesson.delete.byTeacher.DeleteLessonsByTeacherRequest;
import org.example.dto_request.lesson.edit.EditLessonRequest;
import org.example.dto_request.lesson.get.byGroup.GetLessonsByGroupRequest;
import org.example.dto_request.lesson.get.byId.GetLessonByIdRequest;
import org.example.dto_request.lesson.get.byTeacher.GetLessonsByTeacherRequest;
import org.example.dto_response.lesson.AddLessonResponse;
import org.example.dto_response.lesson.GetLessonByIdResponse;
import org.example.dto_response.lesson.GetLessonsByGroupResponse;
import org.example.dto_response.lesson.GetLessonsByTeacherResponse;
import org.example.model.Lesson;
import org.example.services.serviceInterface.LessonService;

import java.text.ParseException;
import java.util.ArrayList;

public class LessonServiceImpl implements LessonService {

    private final LessonDAOImpl lessonDAO = new LessonDAOImpl();

    @Override
    public AddLessonResponse addLesson(AddLessonRequest request) throws ParseException {
        int result = lessonDAO.AddLesson(request.getDate(), request.getNumber(), request.getTeacherId(), request.getGroupId());
        return new AddLessonResponse(result);
    }

    @Override
    public String deleteLessonsByGroup(DeleteLessonsByGroupRequest request) {
        return lessonDAO.DeleteLessonsByGroup(request.getGroupId());
    }

    @Override
    public String deleteLessonById(DeleteLessonByIdRequest request) {
        return lessonDAO.DeleteLessonById(request.getLessonId());
    }

    @Override
    public String deleteLessonsByTeacher(DeleteLessonsByTeacherRequest request) {
        return lessonDAO.DeleteLessonsByTeacher(request.getTeacherId());
    }

    @Override
    public String editLesson(EditLessonRequest request) throws ParseException {
        return lessonDAO.EditLesson(request.getId(), request.getDate(), request.getNumber(), request.getTeacherId(), request.getGroupId());
    }

    @Override
    public GetLessonsByGroupResponse getLessonsByGroup(GetLessonsByGroupRequest request) throws ParseException {

        ArrayList<Lesson> lessons = lessonDAO.getLessonsByGroup(request.getStartDate(), request.getEndDate(), request.getGroupId());
        ArrayList<String> newList = new ArrayList<>();

        for (Lesson lesson : lessons) {
            newList.add(lesson.toString());
        }
        return new GetLessonsByGroupResponse(newList);
    }

    @Override
    public GetLessonByIdResponse getLessonById(GetLessonByIdRequest request) {
        Lesson lesson = lessonDAO.getLessonById(request.getLessonId());
        return new GetLessonByIdResponse(lesson.getDate().toString(), lesson.getNumber(), lesson.getTeacher().getId(), lesson.getGroup().getId());
    }

    @Override
    public GetLessonsByTeacherResponse getLessonsByTeacher(GetLessonsByTeacherRequest request) throws ParseException {

        ArrayList<Lesson> listLessons = lessonDAO.getLessonsByTeacher(request.getStartDate(), request.getEndDate(), request.getTeacherId());
        ArrayList<String> newListLessons = new ArrayList<>();

        for (Lesson lesson : listLessons) {
            newListLessons.add(lesson.toString());
        }

        return new GetLessonsByTeacherResponse(newListLessons);
    }
}
