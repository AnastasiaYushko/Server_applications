package org.example.network_operations.controllers;

import org.apache.http.HttpStatus;
import org.example.SpringConfig;
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

import javax.xml.rpc.ServiceException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class LessonController {

    public static ResponseEntity<?> addLesson(AddLessonRequest request) {

        AddLessonValidator validator = new AddLessonValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        LessonServiceImpl lessonService = SpringConfig.getContext().getBean("lessonServiceImpl", LessonServiceImpl.class);

        try {
            AddLessonResponse lessonResponse = lessonService.addLesson(request);
            return new ResponseEntity<>(lessonResponse, HttpStatus.SC_OK);
        } catch (ParseException | ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ResponseEntity<?> editLesson(EditLessonRequest request) {
        EditLessonValidator validator = new EditLessonValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        LessonServiceImpl lessonService = SpringConfig.getContext().getBean("lessonServiceImpl", LessonServiceImpl.class);

        try {
            String lessonResponse = lessonService.editLesson(request);
            return new ResponseEntity<>(lessonResponse, HttpStatus.SC_OK);
        } catch (ParseException | ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ResponseEntity<?> deleteLessonsByGroup(DeleteLessonsByGroupRequest request) {
        DeleteLessonsByGroupValidator validator = new DeleteLessonsByGroupValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        LessonServiceImpl lessonService = SpringConfig.getContext().getBean("lessonServiceImpl", LessonServiceImpl.class);

        try {
            String dataResponse = lessonService.deleteLessonsByGroup(request);
            return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ResponseEntity<?> deleteLessonById(DeleteLessonByIdRequest request) {
        DeleteLessonByIdValidator validator = new DeleteLessonByIdValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        LessonServiceImpl lessonService = SpringConfig.getContext().getBean("lessonServiceImpl", LessonServiceImpl.class);

        try {
            String dataResponse = lessonService.deleteLessonById(request);
            return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ResponseEntity<?> deleteLessonsByTeacher(DeleteLessonsByTeacherRequest request) {
        DeleteLessonsByTeacherValidator validator = new DeleteLessonsByTeacherValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        LessonServiceImpl lessonService = SpringConfig.getContext().getBean("lessonServiceImpl", LessonServiceImpl.class);

        try {
            String dataResponse = lessonService.deleteLessonsByTeacher(request);
            return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ResponseEntity<?> getLessonsByGroup(GetLessonsByGroupRequest request) throws ParseException {
        GetLessonsByGroupValidator validator = new GetLessonsByGroupValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        LessonServiceImpl lessonService = SpringConfig.getContext().getBean("lessonServiceImpl", LessonServiceImpl.class);

        try {
            GetLessonsByGroupResponse getLessonsByGroupResponse = lessonService.getLessonsByGroup(request);
            return new ResponseEntity<>(getLessonsByGroupResponse, HttpStatus.SC_OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ResponseEntity<?> getLessonById(GetLessonByIdRequest request) {
        GetLessonByIdValidator validator = new GetLessonByIdValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        LessonServiceImpl lessonService = SpringConfig.getContext().getBean("lessonServiceImpl", LessonServiceImpl.class);

        try {
            GetLessonByIdResponse getLessonByIdResponse = lessonService.getLessonById(request);
            return new ResponseEntity<>(getLessonByIdResponse, HttpStatus.SC_OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ResponseEntity<?> getLessonsByTeacher(GetLessonsByTeacherRequest request) throws ParseException {
        GetLessonsByTeacherValidator validator = new GetLessonsByTeacherValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        LessonServiceImpl lessonService = SpringConfig.getContext().getBean("lessonServiceImpl", LessonServiceImpl.class);

        try {
            GetLessonsByTeacherResponse getLessonsByTeacherResponse = lessonService.getLessonsByTeacher(request);
            return new ResponseEntity<>(getLessonsByTeacherResponse, HttpStatus.SC_OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }
}
