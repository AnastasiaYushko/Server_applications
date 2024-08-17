package org.example.services.serviceInterface;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dtoRequest.lesson.AddLessonRequest;
import org.example.dtoRequest.lesson.DeleteLessonsByGroupRequest;
import org.example.dtoRequest.lesson.DeleteLessonByIdRequest;
import org.example.dtoRequest.lesson.DeleteLessonsByTeacherRequest;
import org.example.dtoRequest.lesson.EditLessonRequest;
import org.example.dtoRequest.lesson.GetLessonsByGroupRequest;
import org.example.dtoRequest.lesson.GetLessonByIdRequest;
import org.example.dtoRequest.lesson.GetLessonsByTeacherRequest;
import org.example.dtoResponse.lesson.AddLessonResponse;
import org.example.dtoResponse.lesson.GetLessonByIdResponse;
import org.example.dtoResponse.lesson.GetLessonsByGroupResponse;
import org.example.dtoResponse.lesson.GetLessonsByTeacherResponse;

import javax.jcr.RepositoryException;
import javax.xml.rpc.ServiceException;
import java.text.ParseException;

public interface LessonService {

    AddLessonResponse addLesson(AddLessonRequest request) throws JsonProcessingException, ParseException, ServiceException;

    String deleteLessonsByGroup(DeleteLessonsByGroupRequest request) throws JsonProcessingException, ServiceException;

    String deleteLessonById(DeleteLessonByIdRequest request) throws JsonProcessingException, ServiceException;

    String deleteLessonsByTeacher(DeleteLessonsByTeacherRequest request) throws JsonProcessingException, ServiceException;

    String editLesson(EditLessonRequest request) throws JsonProcessingException, ParseException, ServiceException;

    GetLessonsByGroupResponse getLessonsByGroup(GetLessonsByGroupRequest request) throws JsonProcessingException, ParseException, ServiceException;

    GetLessonByIdResponse getLessonById(GetLessonByIdRequest request) throws ServiceException;

    GetLessonsByTeacherResponse getLessonsByTeacher(GetLessonsByTeacherRequest request) throws JsonProcessingException, ParseException, RepositoryException, ServiceException;

}
