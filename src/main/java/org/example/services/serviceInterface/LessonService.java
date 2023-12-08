package org.example.services.serviceInterface;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto_request.lesson.add.AddLessonRequest;
import org.example.dto_request.lesson.delete.byGroup.DeleteLessonsByGroupRequest;
import org.example.dto_request.lesson.delete.byId.DeleteLessonByIdRequest;
import org.example.dto_request.lesson.delete.byTeacher.DeleteLessonsByTeacherRequest;
import org.example.dto_request.lesson.edit.EditLessonRequest;
import org.example.dto_request.lesson.get.byGroup.GetLessonsByGroupRequest;
import org.example.dto_request.lesson.get.byId.GetLessonByIdRequest;
import org.example.dto_request.lesson.get.byTeacher.GetLessonsByTeacherRequest;
import org.example.dto_response.lesson.*;

public interface LessonService {

    AddLessonResponse addLesson(AddLessonRequest request) throws JsonProcessingException;
    void deleteLessonsByGroup(DeleteLessonsByGroupRequest request) throws JsonProcessingException;
    void deleteLessonById(DeleteLessonByIdRequest request) throws JsonProcessingException;
    void deleteLessonsByTeacher(DeleteLessonsByTeacherRequest request) throws JsonProcessingException;
    EditLessonResponse editLesson(EditLessonRequest request) throws JsonProcessingException;
    GetLessonsByGroupResponse getLessonsByGroup(GetLessonsByGroupRequest request) throws JsonProcessingException;
    GetLessonByIdResponse getLessonById(GetLessonByIdRequest request) throws JsonProcessingException;
    GetLessonsByTeacherResponse getLessonsByTeacher(GetLessonsByTeacherRequest request) throws JsonProcessingException;

}
