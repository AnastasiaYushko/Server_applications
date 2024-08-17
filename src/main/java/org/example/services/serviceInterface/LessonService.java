package org.example.services.serviceInterface;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto_request.lesson.AddLessonRequest;
import org.example.dto_request.lesson.DeleteLessonsByGroupRequest;
import org.example.dto_request.lesson.DeleteLessonByIdRequest;
import org.example.dto_request.lesson.DeleteLessonsByTeacherRequest;
import org.example.dto_request.lesson.EditLessonRequest;
import org.example.dto_request.lesson.GetLessonsByGroupRequest;
import org.example.dto_request.lesson.GetLessonByIdRequest;
import org.example.dto_request.lesson.GetLessonsByTeacherRequest;
import org.example.dto_response.lesson.AddLessonResponse;
import org.example.dto_response.lesson.GetLessonByIdResponse;
import org.example.dto_response.lesson.GetLessonsByGroupResponse;
import org.example.dto_response.lesson.GetLessonsByTeacherResponse;

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
