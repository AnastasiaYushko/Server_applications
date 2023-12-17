package org.example.network_operations.controllers;

import org.apache.http.HttpStatus;
import org.example.dto_request.lessonVisiting.add.AddLessonVisitingRequest;
import org.example.dto_request.lessonVisiting.add.AddLessonVisitingValidator;
import org.example.dto_request.lessonVisiting.delete.DeleteLessonVisitingRequest;
import org.example.dto_request.lessonVisiting.delete.DeleteLessonVisitingValidator;
import org.example.dto_request.lessonVisiting.get.GetLessonVisitingRequest;
import org.example.dto_request.lessonVisiting.get.GetLessonVisitingValidator;
import org.example.dto_response.lessonVisiting.GetLessonVisitingResponse;
import org.example.network_operations.ResponseEntity;
import org.example.services.serviceInterfaceImpl.LessonVisitingServiceImpl;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class LessonVisitingController {
    public static ResponseEntity<String> addLessonVisiting(@RequestBody AddLessonVisitingRequest request) {

        AddLessonVisitingValidator validator = new AddLessonVisitingValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            for (String error : errors) {
                System.out.println(error);
            }
        }

        LessonVisitingServiceImpl lessonVisitingService = new LessonVisitingServiceImpl();

        String dataResponse = lessonVisitingService.addLessonVisiting(request);

        return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
    }

    public static ResponseEntity<String> deleteLessonVisiting(@RequestBody DeleteLessonVisitingRequest request) {

        DeleteLessonVisitingValidator validator = new DeleteLessonVisitingValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            for (String error : errors) {
                System.out.println(error);
            }
        }

        LessonVisitingServiceImpl lessonVisitingService = new LessonVisitingServiceImpl();

        String dataResponse = lessonVisitingService.deleteLessonVisiting(request);

        return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
    }

    public static ResponseEntity<GetLessonVisitingResponse> getLessonVisiting(@RequestBody GetLessonVisitingRequest request) {

        GetLessonVisitingValidator validator = new GetLessonVisitingValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            for (String error : errors) {
                System.out.println(error);
            }
        }

        LessonVisitingServiceImpl lessonVisitingService = new LessonVisitingServiceImpl();

        GetLessonVisitingResponse dataResponse = lessonVisitingService.getLessonVisiting(request);

        return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
    }
}
