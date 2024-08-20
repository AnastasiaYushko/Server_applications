package org.example.services.serviceInterface;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto.dtoRequest.lesson.AddLessonRequest;
import org.example.dto.dtoRequest.lesson.DeleteLessonsByGroupRequest;
import org.example.dto.dtoRequest.lesson.DeleteLessonByIdRequest;
import org.example.dto.dtoRequest.lesson.DeleteLessonsByTeacherRequest;
import org.example.dto.dtoRequest.lesson.EditLessonRequest;
import org.example.dto.dtoRequest.lesson.GetLessonsByGroupRequest;
import org.example.dto.dtoRequest.lesson.GetLessonByIdRequest;
import org.example.dto.dtoRequest.lesson.GetLessonsByTeacherRequest;
import org.example.dto.dtoResponse.lesson.AddLessonResponse;
import org.example.dto.dtoResponse.lesson.GetLessonByIdResponse;
import org.example.dto.dtoResponse.lesson.GetLessonsByGroupResponse;
import org.example.dto.dtoResponse.lesson.GetLessonsByTeacherResponse;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;

import javax.jcr.RepositoryException;
import javax.xml.rpc.ServiceException;
import java.text.ParseException;

public interface LessonService {

    AddLessonResponse addLesson(AddLessonRequest request) throws JsonProcessingException, ParseException, ServiceException, EntityNotFoundInDataBase, AddEntityMatchData;

    String deleteLessonsByGroup(DeleteLessonsByGroupRequest request) throws JsonProcessingException, ServiceException, EntityNotFoundInDataBase;

    String deleteLessonById(DeleteLessonByIdRequest request) throws JsonProcessingException, ServiceException, EntityNotFoundInDataBase;

    String deleteLessonsByTeacher(DeleteLessonsByTeacherRequest request) throws JsonProcessingException, ServiceException, EntityNotFoundInDataBase;

    String editLesson(EditLessonRequest request) throws JsonProcessingException, ParseException, ServiceException, StupidChanges, ChangesEntityLeadToConflict, EntityNotFoundInDataBase;

    GetLessonsByGroupResponse getLessonsByGroup(GetLessonsByGroupRequest request) throws JsonProcessingException, ParseException, ServiceException, EntityNotFoundInDataBase;

    GetLessonByIdResponse getLessonById(GetLessonByIdRequest request) throws ServiceException, EntityNotFoundInDataBase;

    GetLessonsByTeacherResponse getLessonsByTeacher(GetLessonsByTeacherRequest request) throws JsonProcessingException, ParseException, RepositoryException, ServiceException, EntityNotFoundInDataBase;

}
