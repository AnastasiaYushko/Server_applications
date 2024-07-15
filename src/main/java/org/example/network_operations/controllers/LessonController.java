package org.example.network_operations.controllers;

import org.apache.http.HttpStatus;
import org.example.app;
import org.example.dto_request.lesson.add.AddLessonRequest;
import org.example.dto_request.lesson.add.AddLessonValidator;
import org.example.dto_request.lesson.delete.byGroup.DeleteLessonsByGroupRequest;
import org.example.dto_request.lesson.delete.byGroup.DeleteLessonsByGroupValidator;
import org.example.dto_request.lesson.delete.byId.DeleteLessonByIdRequest;
import org.example.dto_request.lesson.delete.byId.DeleteLessonByIdValidator;
import org.example.dto_request.lesson.delete.byTeacher.DeleteLessonsByTeacherRequest;
import org.example.dto_request.lesson.delete.byTeacher.DeleteLessonsByTeacherValidator;
import org.example.dto_request.lesson.edit.EditLessonRequest;
import org.example.dto_request.lesson.edit.EditLessonValidator;
import org.example.dto_request.lesson.get.byGroup.GetLessonsByGroupRequest;
import org.example.dto_request.lesson.get.byGroup.GetLessonsByGroupValidator;
import org.example.dto_request.lesson.get.byId.GetLessonByIdRequest;
import org.example.dto_request.lesson.get.byId.GetLessonByIdValidator;
import org.example.dto_request.lesson.get.byTeacher.GetLessonsByTeacherRequest;
import org.example.dto_request.lesson.get.byTeacher.GetLessonsByTeacherValidator;
import org.example.dto_response.lesson.AddLessonResponse;
import org.example.dto_response.lesson.GetLessonByIdResponse;
import org.example.dto_response.lesson.GetLessonsByGroupResponse;
import org.example.dto_response.lesson.GetLessonsByTeacherResponse;
import org.example.network_operations.ResponseEntity;
import org.example.services.serviceInterfaceImpl.LessonServiceImpl;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Component
public class LessonController {

    public static ResponseEntity<AddLessonResponse> addLesson(AddLessonRequest request) {

        AddLessonValidator validator = new AddLessonValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }

        LessonServiceImpl lessonService = app.getContext().getBean("lesson_service",LessonServiceImpl.class);

        AddLessonResponse lessonResponse;
        int status = HttpStatus.SC_OK;
        try {
            lessonResponse = lessonService.addLesson(request);
        }
        catch (Exception e){
            lessonResponse = null;
            status = HttpStatus.SC_NOT_FOUND;
        }

        return new ResponseEntity<>(lessonResponse, status);
    }

    public static ResponseEntity<String> editLesson(EditLessonRequest request) {
        EditLessonValidator validator = new EditLessonValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }

        LessonServiceImpl lessonService = app.getContext().getBean("lesson_service",LessonServiceImpl.class);

        String lessonResponse;
        int status = HttpStatus.SC_OK;
        try {
            lessonResponse = lessonService.editLesson(request);
        }
        catch (Exception e){
            lessonResponse = null;
            status = HttpStatus.SC_NOT_FOUND;
        }

        return new ResponseEntity<>(lessonResponse, status);

    }

    public static ResponseEntity<String> deleteLessonsByGroup(DeleteLessonsByGroupRequest request) {
        DeleteLessonsByGroupValidator validator = new DeleteLessonsByGroupValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }

        LessonServiceImpl lessonService = app.getContext().getBean("lesson_service",LessonServiceImpl.class);

        String dataResponse;
        int status = HttpStatus.SC_OK;
        try {
            dataResponse = lessonService.deleteLessonsByGroup(request);;
        }
        catch (Exception e){
            dataResponse = e.getMessage();
            status = HttpStatus.SC_NOT_FOUND;
        }

        return new ResponseEntity<>(dataResponse, status);
    }

    public static ResponseEntity<String> deleteLessonById(DeleteLessonByIdRequest request) {
        DeleteLessonByIdValidator validator = new DeleteLessonByIdValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }

        LessonServiceImpl lessonService = app.getContext().getBean("lesson_service",LessonServiceImpl.class);

        String dataResponse;
        int status = HttpStatus.SC_OK;
        try {
            dataResponse = lessonService.deleteLessonById(request);
        }
        catch (Exception e){
            dataResponse = e.getMessage();
            status = HttpStatus.SC_NOT_FOUND;
        }

        return new ResponseEntity<>(dataResponse, status);
    }

    public static ResponseEntity<String> deleteLessonsByTeacher(DeleteLessonsByTeacherRequest request) {
        DeleteLessonsByTeacherValidator validator = new DeleteLessonsByTeacherValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }

        LessonServiceImpl lessonService = app.getContext().getBean("lesson_service",LessonServiceImpl.class);

        String dataResponse;
        int status = HttpStatus.SC_OK;
        try {
            dataResponse = lessonService.deleteLessonsByTeacher(request);
        }
        catch (Exception e){
            dataResponse = e.getMessage();
            status = HttpStatus.SC_NOT_FOUND;
        }

        return new ResponseEntity<>(dataResponse, status);
    }

    public static ResponseEntity<GetLessonsByGroupResponse> getLessonsByGroup(GetLessonsByGroupRequest request) throws ParseException {
        GetLessonsByGroupValidator validator = new GetLessonsByGroupValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }

        LessonServiceImpl lessonService = app.getContext().getBean("lesson_service",LessonServiceImpl.class);

        GetLessonsByGroupResponse getLessonsByGroupResponse = lessonService.getLessonsByGroup(request);

        return new ResponseEntity<>(getLessonsByGroupResponse, HttpStatus.SC_OK);
    }

    public static ResponseEntity<GetLessonByIdResponse> getLessonById(GetLessonByIdRequest request) {
        GetLessonByIdValidator validator = new GetLessonByIdValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }

        LessonServiceImpl lessonService = app.getContext().getBean("lesson_service",LessonServiceImpl.class);

        GetLessonByIdResponse getLessonByIdResponse = lessonService.getLessonById(request);

        return new ResponseEntity<>(getLessonByIdResponse, HttpStatus.SC_OK);
    }

    public static ResponseEntity<GetLessonsByTeacherResponse> getLessonsByTeacher(GetLessonsByTeacherRequest request) throws ParseException {
        GetLessonsByTeacherValidator validator = new GetLessonsByTeacherValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }

        LessonServiceImpl lessonService = app.getContext().getBean("lesson_service",LessonServiceImpl.class);

        GetLessonsByTeacherResponse getLessonsByTeacherResponse = lessonService.getLessonsByTeacher(request);

        return new ResponseEntity<>(getLessonsByTeacherResponse, HttpStatus.SC_OK);
    }
}
