package org.example.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.example.ResponseEntity;
import org.example.SpringConfig;
import org.example.dto.dtoRequest.lessonVisiting.*;
import org.example.dto.dtoResponse.lessonVisiting.AddLessonVisitingResponse;
import org.example.dto.dtoResponse.lessonVisiting.GetLessonVisitingByIdResponse;
import org.example.dto.dtoResponse.lessonVisiting.GetLessonVisitingByLessonIdResponse;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;
import org.example.services.serviceInterfaceImpl.LessonVisitingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/lessonVisiting")
@Validated
public class LessonVisitingController {

    private final LessonVisitingServiceImpl lessonVisitingService;

    @Autowired
    public LessonVisitingController(LessonVisitingServiceImpl lessonVisitingService) {
        this.lessonVisitingService = lessonVisitingService;
    }

    @PostMapping("/add")
    public ResponseEntity<AddLessonVisitingResponse> AddLessonVisiting(@Valid @RequestBody AddLessonVisitingRequest jsonRequest) throws EntityNotFoundInDataBase, AddEntityMatchData {
        AddLessonVisitingResponse dataResponse = lessonVisitingService.addLessonVisiting(jsonRequest);
        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<String> EditLessonVisiting(@Valid @RequestBody EditLessonVisitingRequest jsonRequest) throws StupidChanges, EntityNotFoundInDataBase {
        String dataResponse = lessonVisitingService.editLessonVisiting(jsonRequest);
        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<String> DeleteLessonVisitingById(@Valid @RequestParam("id") @Positive int id) throws EntityNotFoundInDataBase {
        DeleteLessonVisitingByIdRequest deleteLessonVisitingByIdRequest = SpringConfig.getContext().getBean("deleteLessonVisitingByIdRequest", DeleteLessonVisitingByIdRequest.class);
        deleteLessonVisitingByIdRequest.setLessonVisitingId(id);

        String dataResponse = lessonVisitingService.deleteLessonVisitingById(deleteLessonVisitingByIdRequest);
        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }

    @DeleteMapping("/deleteByLessonId")
    public ResponseEntity<String> DeleteLessonVisitingByLessonId(@Valid @RequestParam("id") @Positive int id) throws EntityNotFoundInDataBase {
        DeleteLessonVisitingByLessonIdRequest deleteLessonVisitingByLessonIdRequest = SpringConfig.getContext().getBean("deleteLessonVisitingByLessonIdRequest", DeleteLessonVisitingByLessonIdRequest.class);
        deleteLessonVisitingByLessonIdRequest.setLessonId(id);

        String dataResponse = lessonVisitingService.deleteLessonVisitingByLessonId(deleteLessonVisitingByLessonIdRequest);
        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<?> GetLessonVisitingById(@Valid @RequestParam("id") @Positive int id) throws EntityNotFoundInDataBase {
        GetLessonVisitingByIdRequest getLessonVisitingByIdRequest = SpringConfig.getContext().getBean("getLessonVisitingByIdRequest", GetLessonVisitingByIdRequest.class);
        getLessonVisitingByIdRequest.setLessonVisitingId(id);

        GetLessonVisitingByIdResponse dataResponse = lessonVisitingService.getLessonVisitingById(getLessonVisitingByIdRequest);
        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }

    @GetMapping("/getByLessonId")
    public ResponseEntity<GetLessonVisitingByLessonIdResponse> GetLessonVisitingByLessonId(@Valid @RequestParam("id") @Positive int id) throws EntityNotFoundInDataBase {
        GetLessonVisitingByLessonIdRequest getLessonVisitingByLessonIdRequest = SpringConfig.getContext().getBean("getLessonVisitingByLessonIdRequest", GetLessonVisitingByLessonIdRequest.class);
        getLessonVisitingByLessonIdRequest.setLessonId(id);

        GetLessonVisitingByLessonIdResponse dataResponse = lessonVisitingService.getLessonVisitingByLessonId(getLessonVisitingByLessonIdRequest);
        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }
}


