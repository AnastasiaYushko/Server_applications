package org.example.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.example.SpringConfig;
import org.example.dto_request.lesson.AddLessonRequest;
import org.example.dto_request.lesson.DeleteLessonsByGroupRequest;
import org.example.dto_request.lesson.DeleteLessonByIdRequest;
import org.example.dto_request.lesson.DeleteLessonsByTeacherRequest;
import org.example.dto_request.lesson.EditLessonRequest;
import org.example.dto_request.lesson.GetLessonsByGroupRequest;
import org.example.dto_request.lesson.GetLessonByIdRequest;
import org.example.dto_request.lesson.GetLessonsByTeacherRequest;
import org.example.handler.IHandler;
import org.example.handler.lesson.*;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping(value = "/lesson", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class lesson_controller {
    IHandler classHandler;

    @PostMapping("/add")
    public String AddLesson(@Valid @RequestBody AddLessonRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = SpringConfig.getContext().getBean("addLessonHandler", AddLessonHandler.class);
        return classHandler.handler(jsonRequest);
    }

    @PostMapping("/edit")
    public String EditLesson(@Valid @RequestBody EditLessonRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = SpringConfig.getContext().getBean("editLessonHandler", EditLessonHandler.class);
        return classHandler.handler(jsonRequest);
    }

    @DeleteMapping("/deleteById")
    public String DeleteLessonById(@Valid @RequestParam("id") @Positive int id) throws ParseException, JsonProcessingException {
        DeleteLessonByIdRequest deleteTeacherRequest = SpringConfig.getContext().getBean("deleteLessonByIdRequest", DeleteLessonByIdRequest.class);
        deleteTeacherRequest.setLessonId(id);

        classHandler = SpringConfig.getContext().getBean("deleteLessonByIdHandler", DeleteLessonByIdHandler.class);
        return classHandler.handler(deleteTeacherRequest);
    }

    @DeleteMapping("/deleteByGroup")
    public String DeleteLessonByGroup(@Valid @RequestParam("id") @Positive int id) throws ParseException, JsonProcessingException {
        DeleteLessonsByGroupRequest deleteLessonsByGroupRequest = SpringConfig.getContext().getBean("deleteLessonsByGroupRequest", DeleteLessonsByGroupRequest.class);
        deleteLessonsByGroupRequest.setGroupId(id);

        classHandler = SpringConfig.getContext().getBean("deleteLessonsByGroupHandler", DeleteLessonsByGroupHandler.class);
        return classHandler.handler(deleteLessonsByGroupRequest);
    }

    @DeleteMapping("/deleteByTeacher")
    public String DeleteLessonByTeacher(@Valid @RequestParam("id") @Positive int id) throws ParseException, JsonProcessingException {
        DeleteLessonsByTeacherRequest deleteLessonsByTeacherRequest = SpringConfig.getContext().getBean("deleteLessonsByTeacherRequest", DeleteLessonsByTeacherRequest.class);
        deleteLessonsByTeacherRequest.setTeacherId(id);

        classHandler = SpringConfig.getContext().getBean("deleteLessonsByTeacherHandler", DeleteLessonsByTeacherHandler.class);
        return classHandler.handler(deleteLessonsByTeacherRequest);
    }

    @GetMapping("/getByTeacher")
    public String GetLessonByTeacher(@Valid @RequestParam("id") @Positive int id, @Valid @RequestParam("startDate") @Pattern(regexp = "((0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20|21)\\d\\d))") String startDate,
                                     @Valid @RequestParam("endDate") @Pattern(regexp = "((0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20|21)\\d\\d))") String endDate) throws ParseException, JsonProcessingException {
        GetLessonsByTeacherRequest getLessonsByTeacherRequest = SpringConfig.getContext().getBean("getLessonsByTeacherRequest", GetLessonsByTeacherRequest.class);
        getLessonsByTeacherRequest.setTeacherId(id);
        getLessonsByTeacherRequest.setEndDate(endDate);
        getLessonsByTeacherRequest.setStartDate(startDate);

        classHandler = SpringConfig.getContext().getBean("getLessonByTeacherHandler", GetLessonByTeacherHandler.class);
        return classHandler.handler(getLessonsByTeacherRequest);
    }

    @GetMapping("/getByGroup")
    public String GetLessonByGroup(@Valid @RequestParam("id") @Positive int id, @Valid @RequestParam("startDate") @Pattern(regexp = "((0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20|21)\\d\\d))") String startDate,
                                   @Valid @RequestParam("endDate") @Pattern(regexp = "((0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20|21)\\d\\d))") String endDate) throws ParseException, JsonProcessingException {
        GetLessonsByGroupRequest getLessonsByGroupRequest = SpringConfig.getContext().getBean("getLessonsByGroupRequest", GetLessonsByGroupRequest.class);
        getLessonsByGroupRequest.setStartDate(startDate);
        getLessonsByGroupRequest.setEndDate(endDate);
        getLessonsByGroupRequest.setGroupId(id);

        classHandler = SpringConfig.getContext().getBean("getLessonsByGroupHandler", GetLessonsByGroupHandler.class);
        return classHandler.handler(getLessonsByGroupRequest);
    }

    @GetMapping("/getById")
    public String GetLessonById(@Valid @RequestParam("id") @Positive int id) throws ParseException, JsonProcessingException {
        GetLessonByIdRequest getLessonByIdRequest = SpringConfig.getContext().getBean("getLessonByIdRequest", GetLessonByIdRequest.class);
        getLessonByIdRequest.setLessonId(id);

        classHandler = SpringConfig.getContext().getBean("getLessonByIdHandler", GetLessonByIdHandler.class);
        return classHandler.handler(getLessonByIdRequest);
    }
}

