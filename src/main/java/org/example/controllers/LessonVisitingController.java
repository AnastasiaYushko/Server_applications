package org.example.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

import org.example.SpringConfig;
import org.example.dto.dtoRequest.lessonVisiting.*;
import org.example.dto.dtoResponse.lessonVisiting.AddLessonVisitingResponse;
import org.example.dto.dtoResponse.lessonVisiting.GetLessonVisitingByIdResponse;
import org.example.dto.dtoResponse.lessonVisiting.GetLessonVisitingByLessonIdResponse;
import org.example.ResponseEntity;
import org.example.services.serviceInterfaceImpl.LessonVisitingServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import javax.xml.rpc.ServiceException;

@RestController
@RequestMapping(value = "/lessonVisiting", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class LessonVisitingController {

    private final LessonVisitingServiceImpl lessonVisitingService;

    @Autowired
    public LessonVisitingController(LessonVisitingServiceImpl lessonVisitingService) {
        this.lessonVisitingService = lessonVisitingService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> AddLessonVisiting(@Valid @RequestBody AddLessonVisitingRequest jsonRequest) {
        try {
            AddLessonVisitingResponse dataResponse = lessonVisitingService.addLessonVisiting(jsonRequest);
            return new ResponseEntity<>(dataResponse, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/edit")
    public ResponseEntity<?> EditLessonVisiting(@Valid @RequestBody EditLessonVisitingRequest jsonRequest) {
        try {
            String dataResponse = lessonVisitingService.editLessonVisiting(jsonRequest);
            return new ResponseEntity<>(dataResponse, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<String> DeleteLessonVisitingById(@Valid @RequestParam("id") @Positive int id) {
        DeleteLessonVisitingByIdRequest deleteLessonVisitingByIdRequest = SpringConfig.getContext().getBean("deleteLessonVisitingByIdRequest", DeleteLessonVisitingByIdRequest.class);
        deleteLessonVisitingByIdRequest.setLessonVisitingId(id);
        try {
            String dataResponse = lessonVisitingService.deleteLessonVisitingById(deleteLessonVisitingByIdRequest);
            return new ResponseEntity<>(dataResponse, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteByLessonId")
    public ResponseEntity<String> DeleteLessonVisitingByLessonId(@Valid @RequestParam("id") @Positive int id) {
        DeleteLessonVisitingByLessonIdRequest deleteLessonVisitingByLessonIdRequest = SpringConfig.getContext().getBean("deleteLessonVisitingByLessonIdRequest", DeleteLessonVisitingByLessonIdRequest.class);
        deleteLessonVisitingByLessonIdRequest.setLessonId(id);
        try {
            String dataResponse = lessonVisitingService.deleteLessonVisitingByLessonId(deleteLessonVisitingByLessonIdRequest);
            return new ResponseEntity<>(dataResponse, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getById")
    public ResponseEntity<?> GetLessonVisitingById(@Valid @RequestParam("id") @Positive int id) {
        GetLessonVisitingByIdRequest getLessonVisitingByIdRequest = SpringConfig.getContext().getBean("getLessonVisitingByIdRequest", GetLessonVisitingByIdRequest.class);
        getLessonVisitingByIdRequest.setLessonVisitingId(id);
        try {
            GetLessonVisitingByIdResponse dataResponse = lessonVisitingService.getLessonVisitingById(getLessonVisitingByIdRequest);
            return new ResponseEntity<>(dataResponse, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getByLessonId")
    public ResponseEntity<?> GetLessonVisitingByLessonId(@Valid @RequestParam("id") @Positive int id) {
        GetLessonVisitingByLessonIdRequest getLessonVisitingByLessonIdRequest = SpringConfig.getContext().getBean("getLessonVisitingByLessonIdRequest", GetLessonVisitingByLessonIdRequest.class);
        getLessonVisitingByLessonIdRequest.setLessonId(id);
        try {
            GetLessonVisitingByLessonIdResponse dataResponse = lessonVisitingService.getLessonVisitingByLessonId(getLessonVisitingByLessonIdRequest);
            return new ResponseEntity<>(dataResponse, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}


