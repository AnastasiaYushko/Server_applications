package org.example.services.serviceInterfaceImpl;

import org.example.SpringConfig;
import org.example.dao.daoRepositoriesImplements.LessonDAOImpl;
import org.example.dto.dtoRequest.lesson.*;
import org.example.dto.dtoResponse.lesson.AddLessonResponse;
import org.example.dto.dtoResponse.lesson.GetLessonByIdResponse;
import org.example.dto.dtoResponse.lesson.GetLessonsByGroupResponse;
import org.example.dto.dtoResponse.lesson.GetLessonsByTeacherResponse;
import org.example.model.Lesson;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;
import org.example.services.serviceInterface.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonDAOImpl lessonDAO;

    @Autowired
    public LessonServiceImpl(LessonDAOImpl lessonDAO) {
        this.lessonDAO = lessonDAO;
    }

    @Override
    public AddLessonResponse addLesson(AddLessonRequest request) throws ParseException, EntityNotFoundInDataBase, AddEntityMatchData {
        int result = lessonDAO.AddLesson(request.getDate(), request.getNumber(), request.getTeacherId(), request.getSubjectId(), request.getGroupId());

        AddLessonResponse addLessonResponse = SpringConfig.getContext().getBean("addLessonResponse", AddLessonResponse.class);
        addLessonResponse.setId(result);
        return addLessonResponse;
    }

    @Override
    public String deleteLessonsByGroup(DeleteLessonsByGroupRequest request) throws EntityNotFoundInDataBase {
        return lessonDAO.DeleteLessonsByGroup(request.getGroupId());
    }

    @Override
    public String deleteLessonById(DeleteLessonByIdRequest request) throws EntityNotFoundInDataBase {
        return lessonDAO.DeleteLessonById(request.getLessonId());
    }

    @Override
    public String deleteLessonsByTeacher(DeleteLessonsByTeacherRequest request) throws EntityNotFoundInDataBase {
        return lessonDAO.DeleteLessonsByTeacher(request.getTeacherId());
    }

    @Override
    public String editLesson(EditLessonRequest request) throws ParseException, StupidChanges, ChangesEntityLeadToConflict, EntityNotFoundInDataBase {
        return lessonDAO.EditLesson(request.getId(), request.getDate(), request.getNumber(), request.getTeacherId(), request.getGroupId(), request.getSubjectId());
    }

    @Override
    public GetLessonsByGroupResponse getLessonsByGroup(GetLessonsByGroupRequest request) throws ParseException, EntityNotFoundInDataBase {

        ArrayList<Lesson> lessons = lessonDAO.getLessonsByGroup(request.getStartDate(), request.getEndDate(), request.getGroupId());

        ArrayList<String> newList = new ArrayList<>();

        for (Lesson lesson : lessons) {
            newList.add(lesson.toString());
        }

        GetLessonsByGroupResponse getLessonsByGroupResponse = SpringConfig.getContext().getBean("getLessonsByGroupResponse", GetLessonsByGroupResponse.class);
        getLessonsByGroupResponse.setListLessons(newList);
        return getLessonsByGroupResponse;
    }

    @Override
    public GetLessonByIdResponse getLessonById(GetLessonByIdRequest request) throws EntityNotFoundInDataBase {
        Lesson lesson = lessonDAO.getLessonById(request.getLessonId());

        GetLessonByIdResponse getLessonByIdResponse = SpringConfig.getContext().getBean("getLessonByIdResponse", GetLessonByIdResponse.class);
        getLessonByIdResponse.setDate(dateToStringFormat(lesson.getDate()));
        getLessonByIdResponse.setNumber(lesson.getNumber());
        getLessonByIdResponse.setTeacherId(lesson.getTeacher().getId());
        getLessonByIdResponse.setGroupId(lesson.getGroup().getId());

        return getLessonByIdResponse;

    }

    @Override
    public GetLessonsByTeacherResponse getLessonsByTeacher(GetLessonsByTeacherRequest request) throws ParseException, EntityNotFoundInDataBase {

        ArrayList<Lesson> listLessons = lessonDAO.getLessonsByTeacher(request.getStartDate(), request.getEndDate(), request.getTeacherId());

        ArrayList<String> newListLessons = new ArrayList<>();
        for (Lesson lesson : listLessons) {
            newListLessons.add(lesson.toString());
        }

        GetLessonsByTeacherResponse getLessonsByTeacherResponse = SpringConfig.getContext().getBean("getLessonsByTeacherResponse", GetLessonsByTeacherResponse.class);
        getLessonsByTeacherResponse.setListLessons(newListLessons);

        return getLessonsByTeacherResponse;
    }

    public String dateToStringFormat(Date date) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return df.format(date);
    }
}
