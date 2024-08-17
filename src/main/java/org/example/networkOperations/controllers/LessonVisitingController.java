/*
package org.example.networkOperations.controllers;

import org.apache.http.HttpStatus;
import org.example.SpringConfig;
import org.example.dtoRequest.lessonVisiting.AddLessonVisitingRequest;
import org.example.dtoRequest.lessonVisiting.validation.AddLessonVisitingValidator;
import org.example.dtoRequest.lessonVisiting.DeleteLessonVisitingByIdRequest;
import org.example.dtoRequest.lessonVisiting.validation.DeleteLessonVisitingByIdValidator;
import org.example.dtoRequest.lessonVisiting.DeleteLessonVisitingByLessonIdRequest;
import org.example.dtoRequest.lessonVisiting.validation.DeleteLessonVisitingByLessonIdValidator;
import org.example.dtoRequest.lessonVisiting.EditLessonVisitingRequest;
import org.example.dtoRequest.lessonVisiting.validation.EditLessonVisitingValidator;
import org.example.dtoRequest.lessonVisiting.GetLessonVisitingByLessonIdRequest;
import org.example.dtoRequest.lessonVisiting.validation.GetLessonVisitingByLessonIdValidator;
import org.example.dtoRequest.lessonVisiting.GetLessonVisitingByIdRequest;
import org.example.dtoRequest.lessonVisiting.validation.GetLessonVisitingByIdValidator;
import org.example.dtoResponse.lessonVisiting.AddLessonVisitingResponse;
import org.example.dtoResponse.lessonVisiting.GetLessonVisitingByIdResponse;
import org.example.dtoResponse.lessonVisiting.GetLessonVisitingByLessonIdResponse;
import org.example.ResponseEntity;
import org.example.services.serviceInterfaceImpl.LessonVisitingServiceImpl;

import javax.xml.rpc.ServiceException;
import java.util.ArrayList;
import java.util.List;

public class LessonVisitingController {

    public static ResponseEntity<?> addLessonVisiting(AddLessonVisitingRequest request) {

        AddLessonVisitingValidator validator = new AddLessonVisitingValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        LessonVisitingServiceImpl lessonVisitingService = SpringConfig.getContext().getBean("lessonVisitingServiceImpl", LessonVisitingServiceImpl.class);

        try {
            AddLessonVisitingResponse dataResponse = lessonVisitingService.addLessonVisiting(request);
            return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
        } catch (ServiceException e) {
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

        LessonVisitingServiceImpl lessonVisitingService = SpringConfig.getContext().getBean("lessonVisitingServiceImpl", LessonVisitingServiceImpl.class);

        try {
            String dataResponse = lessonVisitingService.deleteLessonVisitingById(request);
            return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
        } catch (ServiceException e) {
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

        LessonVisitingServiceImpl lessonVisitingService = SpringConfig.getContext().getBean("lessonVisitingServiceImpl", LessonVisitingServiceImpl.class);

        try {
            String dataResponse = lessonVisitingService.deleteLessonVisitingByLessonId(request);
            return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
        } catch (ServiceException e) {
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

        LessonVisitingServiceImpl lessonVisitingService = SpringConfig.getContext().getBean("lessonVisitingServiceImpl", LessonVisitingServiceImpl.class);

        try {
            GetLessonVisitingByIdResponse dataResponse = lessonVisitingService.getLessonVisitingById(request);
            return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
        } catch (ServiceException e) {
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

        LessonVisitingServiceImpl lessonVisitingService = SpringConfig.getContext().getBean("lessonVisitingServiceImpl", LessonVisitingServiceImpl.class);

        try {
            GetLessonVisitingByLessonIdResponse dataResponse = lessonVisitingService.getLessonVisitingByLessonId(request);
            return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
        } catch (ServiceException e) {
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

        LessonVisitingServiceImpl lessonVisitingService = SpringConfig.getContext().getBean("lessonVisitingServiceImpl", LessonVisitingServiceImpl.class);

        try {
            String dataResponse = lessonVisitingService.editLessonVisiting(request);
            return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }
}
 */
