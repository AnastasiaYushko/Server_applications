package org.example.services.serviceInterfaceImpl;

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
import org.example.services.serviceInterface.LessonService;

public class LessonServiceImpl implements LessonService {
    @Override
    public AddLessonResponse addLesson(AddLessonRequest request) throws JsonProcessingException {
        return null;
    }

    @Override
    public void deleteLessonsByGroup(DeleteLessonsByGroupRequest request) throws JsonProcessingException {}

    @Override
    public void deleteLessonById(DeleteLessonByIdRequest request) throws JsonProcessingException {

    }

    @Override
    public void deleteLessonsByTeacher(DeleteLessonsByTeacherRequest request) throws JsonProcessingException {

    }

    @Override
    public EditLessonResponse editLesson(EditLessonRequest request) throws JsonProcessingException {
        return null;
    }

    @Override
    public GetLessonsByGroupResponse getLessonsByGroup(GetLessonsByGroupRequest request) throws JsonProcessingException {
        return null;
    }

    @Override
    public GetLessonByIdResponse getLessonById(GetLessonByIdRequest request) throws JsonProcessingException {
        return null;
    }

    @Override
    public GetLessonsByTeacherResponse getLessonsByTeacher(GetLessonsByTeacherRequest request) throws JsonProcessingException {
        return null;
    }
}
