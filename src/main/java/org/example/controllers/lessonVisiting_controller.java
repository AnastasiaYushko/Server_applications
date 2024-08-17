package org.example.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.example.SpringConfig;
import org.example.dto_request.lessonVisiting.AddLessonVisitingRequest;
import org.example.dto_request.lessonVisiting.DeleteLessonVisitingByIdRequest;
import org.example.dto_request.lessonVisiting.DeleteLessonVisitingByLessonIdRequest;
import org.example.dto_request.lessonVisiting.EditLessonVisitingRequest;
import org.example.dto_request.lessonVisiting.GetLessonVisitingByLessonIdRequest;
import org.example.dto_request.lessonVisiting.GetLessonVisitingByIdRequest;
import org.example.handler.IHandler;
import org.example.handler.lessonVisiting.*;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping(value = "/lessonVisiting", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class lessonVisiting_controller {
    IHandler classHandler;

    @PostMapping("/add")
    public String AddLessonVisiting(@Valid @RequestBody AddLessonVisitingRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = SpringConfig.getContext().getBean("addLessonVisitingHandler", AddLessonVisitingHandler.class);
        return classHandler.handler(jsonRequest);
    }

    @PostMapping("/edit")
    public String EditLessonVisiting(@Valid @RequestBody EditLessonVisitingRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = SpringConfig.getContext().getBean("editLessonVisitingHandler", EditLessonVisitingHandler.class);
        return classHandler.handler(jsonRequest);
    }

    @DeleteMapping("/deleteById")
    public String DeleteLessonVisitingById(@Valid @RequestParam("id") @Positive int id) throws ParseException, JsonProcessingException {
        DeleteLessonVisitingByIdRequest deleteLessonVisitingByIdRequest = SpringConfig.getContext().getBean("deleteLessonVisitingByIdRequest", DeleteLessonVisitingByIdRequest.class);
        deleteLessonVisitingByIdRequest.setLessonVisitingId(id);

        classHandler = SpringConfig.getContext().getBean("deleteLessonVisitingByIdHandler", DeleteLessonVisitingByIdHandler.class);
        return classHandler.handler(deleteLessonVisitingByIdRequest);
    }

    @DeleteMapping("/deleteByLessonId")
    public String DeleteLessonVisitingByLessonId(@Valid @RequestParam("id") @Positive int id) throws ParseException, JsonProcessingException {
        DeleteLessonVisitingByLessonIdRequest deleteLessonVisitingByLessonIdRequest = SpringConfig.getContext().getBean("deleteLessonVisitingByLessonIdRequest", DeleteLessonVisitingByLessonIdRequest.class);
        deleteLessonVisitingByLessonIdRequest.setLessonId(id);

        classHandler = SpringConfig.getContext().getBean("deleteLessonVisitingByLessonIdHandler", DeleteLessonVisitingByLessonIdHandler.class);
        return classHandler.handler(deleteLessonVisitingByLessonIdRequest);
    }

    @GetMapping("/getById")
    public String GetLessonVisitingById(@Valid @RequestParam("id") @Positive int id) throws ParseException, JsonProcessingException {
        GetLessonVisitingByIdRequest getLessonVisitingByIdRequest = SpringConfig.getContext().getBean("getLessonVisitingByIdRequest", GetLessonVisitingByIdRequest.class);
        getLessonVisitingByIdRequest.setLessonVisitingId(id);

        classHandler = SpringConfig.getContext().getBean("getLessonVisitingByIdHandler", GetLessonVisitingByIdHandler.class);
        return classHandler.handler(getLessonVisitingByIdRequest);
    }

    @GetMapping("/getByLessonId")
    public String GetLessonVisitingByLessonId(@Valid @RequestParam("id") @Positive int id) throws ParseException, JsonProcessingException {
        GetLessonVisitingByLessonIdRequest getLessonVisitingByLessonIdRequest = SpringConfig.getContext().getBean("getLessonVisitingByLessonIdRequest", GetLessonVisitingByLessonIdRequest.class);
        getLessonVisitingByLessonIdRequest.setLessonId(id);

        classHandler = SpringConfig.getContext().getBean("getLessonVisitingByLessonIdHandler", GetLessonVisitingByLessonIdHandler.class);
        return classHandler.handler(getLessonVisitingByLessonIdRequest);
    }
}


