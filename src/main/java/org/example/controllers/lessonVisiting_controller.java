package org.example.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.SpringConfig;
import org.example.dto_request.lessonVisiting.add.AddLessonVisitingRequest;
import org.example.dto_request.lessonVisiting.delete.byId.DeleteLessonVisitingByIdRequest;
import org.example.dto_request.lessonVisiting.delete.byLessonId.DeleteLessonVisitingByLessonIdRequest;
import org.example.dto_request.lessonVisiting.edit.EditLessonVisitingRequest;
import org.example.dto_request.lessonVisiting.get.byILessonId.GetLessonVisitingByLessonIdRequest;
import org.example.dto_request.lessonVisiting.get.byId.GetLessonVisitingByIdRequest;
import org.example.handler.IHandler;
import org.example.handler.lessonVisiting.*;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/lessonVisiting")
public class lessonVisiting_controller {
    IHandler classHandler;

    @PostMapping("/add")
    public String AddLessonVisiting(@RequestBody AddLessonVisitingRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = SpringConfig.getContext().getBean("addLessonVisitingHandler", AddLessonVisitingHandler.class);
        return classHandler.handler(jsonRequest);
    }

    @PostMapping("/edit")
    public String EditLessonVisiting(@RequestBody EditLessonVisitingRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = SpringConfig.getContext().getBean("editLessonVisitingHandler", EditLessonVisitingHandler.class);
        return classHandler.handler(jsonRequest);
    }

    @DeleteMapping("/deleteById")
    public String DeleteLessonVisitingById(@RequestBody DeleteLessonVisitingByIdRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = SpringConfig.getContext().getBean("deleteLessonVisitingByIdHandler", DeleteLessonVisitingByIdHandler.class);
        return classHandler.handler(jsonRequest);
    }

    @DeleteMapping("/deleteByLessonId")
    public String DeleteLessonVisitingByLessonId(@RequestBody DeleteLessonVisitingByLessonIdRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = SpringConfig.getContext().getBean("deleteLessonVisitingByLessonIdHandler", DeleteLessonVisitingByLessonIdHandler.class);
        return classHandler.handler(jsonRequest);
    }

    @GetMapping("/getById")
    public String GetLessonVisitingById(@RequestParam("id") int id) throws ParseException, JsonProcessingException {
        GetLessonVisitingByIdRequest getLessonVisitingByIdRequest = SpringConfig.getContext().getBean("getLessonVisitingByIdRequest", GetLessonVisitingByIdRequest.class);
        getLessonVisitingByIdRequest.setLessonVisitingId(id);

        classHandler = SpringConfig.getContext().getBean("getLessonVisitingByIdHandler", GetLessonVisitingByIdHandler.class);
        return classHandler.handler(getLessonVisitingByIdRequest);
    }

    @GetMapping("/getByLessonId")
    public String GetLessonVisitingByLessonId(@RequestParam("id") int id) throws ParseException, JsonProcessingException {
        GetLessonVisitingByLessonIdRequest getLessonVisitingByLessonIdRequest = SpringConfig.getContext().getBean("getLessonVisitingByLessonIdRequest", GetLessonVisitingByLessonIdRequest.class);
        getLessonVisitingByLessonIdRequest.setLessonId(id);

        classHandler = SpringConfig.getContext().getBean("getLessonVisitingByLessonIdHandler", GetLessonVisitingByLessonIdHandler.class);
        return classHandler.handler(getLessonVisitingByLessonIdRequest);
    }
}


