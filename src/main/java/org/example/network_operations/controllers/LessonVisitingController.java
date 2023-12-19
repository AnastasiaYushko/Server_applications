package org.example.network_operations.controllers;

import org.apache.http.HttpStatus;
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
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class LessonVisitingController {
    public static ResponseEntity<AddLessonVisitingResponse> addLessonVisiting(@RequestBody AddLessonVisitingRequest request) {

        AddLessonVisitingValidator validator = new AddLessonVisitingValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }

        LessonVisitingServiceImpl lessonVisitingService = new LessonVisitingServiceImpl();

        AddLessonVisitingResponse dataResponse = lessonVisitingService.addLessonVisiting(request);

        return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
    }

    public static ResponseEntity<String> deleteLessonVisitingById(@RequestBody DeleteLessonVisitingByIdRequest request) {

        DeleteLessonVisitingByIdValidator validator = new DeleteLessonVisitingByIdValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }

        LessonVisitingServiceImpl lessonVisitingService = new LessonVisitingServiceImpl();

        String dataResponse = lessonVisitingService.deleteLessonVisitingById(request);

        return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
    }

    public static ResponseEntity<String> deleteLessonVisitingByLessonId(@RequestBody DeleteLessonVisitingByLessonIdRequest request){
        DeleteLessonVisitingByLessonIdValidator validator = new DeleteLessonVisitingByLessonIdValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }

        LessonVisitingServiceImpl lessonVisitingService = new LessonVisitingServiceImpl();

        String dataResponse = lessonVisitingService.deleteLessonVisitingByLessonId(request);

        return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
    }
    public static ResponseEntity<GetLessonVisitingByIdResponse> getLessonVisitingById(@RequestBody GetLessonVisitingByIdRequest request) {

        GetLessonVisitingByIdValidator validator = new GetLessonVisitingByIdValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }

        LessonVisitingServiceImpl lessonVisitingService = new LessonVisitingServiceImpl();

        GetLessonVisitingByIdResponse dataResponse = lessonVisitingService.getLessonVisitingById(request);

        return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
    }
    public static ResponseEntity<GetLessonVisitingByLessonIdResponse> getLessonVisitingByLessonId(@RequestBody GetLessonVisitingByLessonIdRequest request){
        GetLessonVisitingByLessonIdValidator validator = new GetLessonVisitingByLessonIdValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }

        LessonVisitingServiceImpl lessonVisitingService = new LessonVisitingServiceImpl();

        GetLessonVisitingByLessonIdResponse dataResponse = lessonVisitingService.getLessonVisitingByLessonId(request);

        return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
    }

    public static ResponseEntity<String> editLessonVisiting(@RequestBody EditLessonVisitingRequest request){
        EditLessonVisitingValidator validator = new EditLessonVisitingValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }

        LessonVisitingServiceImpl lessonVisitingService = new LessonVisitingServiceImpl();

        String dataResponse = lessonVisitingService.editLessonVisiting(request);

        return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
    }
}
