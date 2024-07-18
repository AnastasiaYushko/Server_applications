package org.example.network_operations.controllers;

import org.apache.http.HttpStatus;
import org.example.SpringConfig;
import org.example.dto_request.lessonVisiting.add.AddLessonVisitingRequest;
import org.example.dto_request.lessonVisiting.add.AddLessonVisitingValidator;
import org.example.dto_request.lessonVisiting.delete.byId.DeleteLessonVisitingByIdRequest;
import org.example.dto_request.lessonVisiting.delete.byId.DeleteLessonVisitingByIdValidator;
import org.example.dto_request.lessonVisiting.delete.byLessonId.DeleteLessonVisitingByLessonIdRequest;
import org.example.dto_request.lessonVisiting.delete.byLessonId.DeleteLessonVisitingByLessonIdValidator;
import org.example.dto_request.lessonVisiting.edit.EditLessonVisitingRequest;
import org.example.dto_request.lessonVisiting.edit.EditLessonVisitingValidator;
import org.example.dto_request.lessonVisiting.get.byILessonId.GetLessonVisitingByLessonIdRequest;
import org.example.dto_request.lessonVisiting.get.byILessonId.GetLessonVisitingByLessonIdValidator;
import org.example.dto_request.lessonVisiting.get.byId.GetLessonVisitingByIdRequest;
import org.example.dto_request.lessonVisiting.get.byId.GetLessonVisitingByIdValidator;
import org.example.dto_response.lessonVisiting.AddLessonVisitingResponse;
import org.example.dto_response.lessonVisiting.GetLessonVisitingByIdResponse;
import org.example.dto_response.lessonVisiting.GetLessonVisitingByLessonIdResponse;
import org.example.network_operations.ResponseEntity;
import org.example.services.serviceInterfaceImpl.LessonVisitingServiceImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LessonVisitingController {
    public static ResponseEntity<?> addLessonVisiting(AddLessonVisitingRequest request) {

        AddLessonVisitingValidator validator = new AddLessonVisitingValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        LessonVisitingServiceImpl lessonVisitingService = SpringConfig.getContext().getBean("lesson_visiting_service", LessonVisitingServiceImpl.class);

        try {
            AddLessonVisitingResponse dataResponse = lessonVisitingService.addLessonVisiting(request);
            return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ResponseEntity<?> deleteLessonVisitingById(DeleteLessonVisitingByIdRequest request) {

        DeleteLessonVisitingByIdValidator validator = new DeleteLessonVisitingByIdValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        LessonVisitingServiceImpl lessonVisitingService = SpringConfig.getContext().getBean("lesson_visiting_service", LessonVisitingServiceImpl.class);

        try {
            String dataResponse = lessonVisitingService.deleteLessonVisitingById(request);
            return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ResponseEntity<?> deleteLessonVisitingByLessonId(DeleteLessonVisitingByLessonIdRequest request) {
        DeleteLessonVisitingByLessonIdValidator validator = new DeleteLessonVisitingByLessonIdValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        LessonVisitingServiceImpl lessonVisitingService = SpringConfig.getContext().getBean("lesson_visiting_service", LessonVisitingServiceImpl.class);

        try {
            String dataResponse = lessonVisitingService.deleteLessonVisitingByLessonId(request);
            return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ResponseEntity<?> getLessonVisitingById(GetLessonVisitingByIdRequest request) {

        GetLessonVisitingByIdValidator validator = new GetLessonVisitingByIdValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        LessonVisitingServiceImpl lessonVisitingService = SpringConfig.getContext().getBean("lesson_visiting_service", LessonVisitingServiceImpl.class);

        try {
            GetLessonVisitingByIdResponse dataResponse = lessonVisitingService.getLessonVisitingById(request);
            return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ResponseEntity<?> getLessonVisitingByLessonId(GetLessonVisitingByLessonIdRequest request) {
        GetLessonVisitingByLessonIdValidator validator = new GetLessonVisitingByLessonIdValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        LessonVisitingServiceImpl lessonVisitingService = SpringConfig.getContext().getBean("lesson_visiting_service", LessonVisitingServiceImpl.class);

        try {
            GetLessonVisitingByLessonIdResponse dataResponse = lessonVisitingService.getLessonVisitingByLessonId(request);
            return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ResponseEntity<?> editLessonVisiting(EditLessonVisitingRequest request) {
        EditLessonVisitingValidator validator = new EditLessonVisitingValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        LessonVisitingServiceImpl lessonVisitingService = SpringConfig.getContext().getBean("lesson_visiting_service", LessonVisitingServiceImpl.class);

        try {
            String dataResponse = lessonVisitingService.editLessonVisiting(request);
            return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }
}
