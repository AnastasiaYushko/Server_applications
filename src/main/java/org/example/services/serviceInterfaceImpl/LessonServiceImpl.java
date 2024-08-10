package org.example.services.serviceInterfaceImpl;

import org.example.SpringConfig;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jcr.RepositoryException;
import javax.xml.rpc.ServiceException;
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
    public AddLessonResponse addLesson(AddLessonRequest request) throws ParseException, ServiceException {
        int result;
        try {
            result = lessonDAO.AddLesson(request.getDate(), request.getNumber(), request.getTeacherId(), request.getSubjectId(), request.getGroupId());
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage());
        }
        AddLessonResponse addLessonResponse = SpringConfig.getContext().getBean("addLessonResponse", AddLessonResponse.class);
        addLessonResponse.setId(result);
        return addLessonResponse;
    }

    @Override
    public String deleteLessonsByGroup(DeleteLessonsByGroupRequest request) throws ServiceException {
        try {
            return lessonDAO.DeleteLessonsByGroup(request.getGroupId());
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public String deleteLessonById(DeleteLessonByIdRequest request) throws ServiceException {
        try {
            return lessonDAO.DeleteLessonById(request.getLessonId());
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public String deleteLessonsByTeacher(DeleteLessonsByTeacherRequest request) throws ServiceException {
        try {
            return lessonDAO.DeleteLessonsByTeacher(request.getTeacherId());
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public String editLesson(EditLessonRequest request) throws ParseException, ServiceException {
        try {
            return lessonDAO.EditLesson(request.getId(), request.getDate(), request.getNumber(), request.getTeacherId(), request.getGroupId(), request.getSubjectId());
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public GetLessonsByGroupResponse getLessonsByGroup(GetLessonsByGroupRequest request) throws ParseException, ServiceException {

        ArrayList<Lesson> lessons;

        try {
            lessons = lessonDAO.getLessonsByGroup(request.getStartDate(), request.getEndDate(), request.getGroupId());
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
        ArrayList<String> newList = new ArrayList<>();

        for (Lesson lesson : lessons) {
            newList.add(lesson.toString());
        }

        GetLessonsByGroupResponse getLessonsByGroupResponse = SpringConfig.getContext().getBean("getLessonsByGroupResponse", GetLessonsByGroupResponse.class);
        getLessonsByGroupResponse.setListLessons(newList);
        return getLessonsByGroupResponse;
    }

    @Override
    public GetLessonByIdResponse getLessonById(GetLessonByIdRequest request) throws ServiceException {
        try {
            Lesson lesson = lessonDAO.getLessonById(request.getLessonId());

            GetLessonByIdResponse getLessonByIdResponse = SpringConfig.getContext().getBean("getLessonByIdResponse", GetLessonByIdResponse.class);
            getLessonByIdResponse.setDate(dateToStringFormat(lesson.getDate()));
            getLessonByIdResponse.setNumber(lesson.getNumber());
            getLessonByIdResponse.setTeacherId(lesson.getTeacher().getId());
            getLessonByIdResponse.setGroupId(lesson.getGroup().getId());

            return getLessonByIdResponse;
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public GetLessonsByTeacherResponse getLessonsByTeacher(GetLessonsByTeacherRequest request) throws ParseException, ServiceException {

        ArrayList<Lesson> listLessons;

        try {
            listLessons = lessonDAO.getLessonsByTeacher(request.getStartDate(), request.getEndDate(), request.getTeacherId());
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage());
        }

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
