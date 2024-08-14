package org.example.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.SpringConfig;
import org.example.dto_request.lesson.add.AddLessonRequest;
import org.example.dto_request.lesson.delete.byGroup.DeleteLessonsByGroupRequest;
import org.example.dto_request.lesson.delete.byId.DeleteLessonByIdRequest;
import org.example.dto_request.lesson.delete.byTeacher.DeleteLessonsByTeacherRequest;
import org.example.dto_request.lesson.edit.EditLessonRequest;
import org.example.dto_request.lesson.get.byGroup.GetLessonsByGroupRequest;
import org.example.dto_request.lesson.get.byId.GetLessonByIdRequest;
import org.example.dto_request.lesson.get.byTeacher.GetLessonsByTeacherRequest;
import org.example.handler.IHandler;
import org.example.handler.lesson.*;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/lesson")
public class lesson_controller {
    IHandler classHandler;

    @PostMapping("/add")
    public String AddLesson(@RequestBody AddLessonRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = SpringConfig.getContext().getBean("addLessonHandler", AddLessonHandler.class);
        return classHandler.handler(jsonRequest);
    }

    @PostMapping("/edit")
    public String EditLesson(@RequestBody EditLessonRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = SpringConfig.getContext().getBean("editLessonHandler", EditLessonHandler.class);
        return classHandler.handler(jsonRequest);
    }

    @DeleteMapping("/deleteById")
    public String DeleteLessonById(@RequestParam("id") int id) throws ParseException, JsonProcessingException {
        DeleteLessonByIdRequest deleteTeacherRequest = SpringConfig.getContext().getBean("deleteLessonByIdRequest", DeleteLessonByIdRequest.class);
        deleteTeacherRequest.setLessonId(id);

        classHandler = SpringConfig.getContext().getBean("deleteLessonByIdHandler", DeleteLessonByIdHandler.class);
        return classHandler.handler(deleteTeacherRequest);
    }

    @DeleteMapping("/deleteByGroup")
    public String DeleteLessonByGroup(@RequestParam("id") int id) throws ParseException, JsonProcessingException {
        DeleteLessonsByGroupRequest deleteLessonsByGroupRequest = SpringConfig.getContext().getBean("deleteLessonsByGroupRequest", DeleteLessonsByGroupRequest.class);
        deleteLessonsByGroupRequest.setGroupId(id);

        classHandler = SpringConfig.getContext().getBean("deleteLessonsByGroupHandler", DeleteLessonsByGroupHandler.class);
        return classHandler.handler(deleteLessonsByGroupRequest);
    }

    @DeleteMapping("/deleteByTeacher")
    public String DeleteLessonByTeacher(@RequestParam("id") int id) throws ParseException, JsonProcessingException {
        DeleteLessonsByTeacherRequest deleteLessonsByTeacherRequest = SpringConfig.getContext().getBean("deleteLessonsByTeacherRequest", DeleteLessonsByTeacherRequest.class);
        deleteLessonsByTeacherRequest.setTeacherId(id);

        classHandler = SpringConfig.getContext().getBean("deleteLessonsByTeacherHandler", DeleteLessonsByTeacherHandler.class);
        return classHandler.handler(deleteLessonsByTeacherRequest);
    }

    @GetMapping("/getByTeacher")
    public String GetLessonByTeacher(@RequestParam("id") int id, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) throws ParseException, JsonProcessingException {
        GetLessonsByTeacherRequest getLessonsByTeacherRequest = SpringConfig.getContext().getBean("getLessonsByTeacherRequest", GetLessonsByTeacherRequest.class);
        getLessonsByTeacherRequest.setTeacherId(id);
        getLessonsByTeacherRequest.setEndDate(endDate);
        getLessonsByTeacherRequest.setStartDate(startDate);

        classHandler = SpringConfig.getContext().getBean("getLessonByTeacherHandler", GetLessonByTeacherHandler.class);
        return classHandler.handler(getLessonsByTeacherRequest);
    }

    @GetMapping("/getByGroup")
    public String GetLessonByGroup(@RequestParam("id") int id, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) throws ParseException, JsonProcessingException {
        GetLessonsByGroupRequest getLessonsByGroupRequest = SpringConfig.getContext().getBean("getLessonsByGroupRequest", GetLessonsByGroupRequest.class);
        getLessonsByGroupRequest.setStartDate(startDate);
        getLessonsByGroupRequest.setEndDate(endDate);
        getLessonsByGroupRequest.setGroupId(id);

        classHandler = SpringConfig.getContext().getBean("getLessonsByGroupHandler", GetLessonsByGroupHandler.class);
        return classHandler.handler(getLessonsByGroupRequest);
    }

    @GetMapping("/getById")
    public String GetLessonById(@RequestParam("id") int id) throws ParseException, JsonProcessingException {
        GetLessonByIdRequest getLessonByIdRequest = SpringConfig.getContext().getBean("getLessonByIdRequest", GetLessonByIdRequest.class);
        getLessonByIdRequest.setLessonId(id);

        classHandler = SpringConfig.getContext().getBean("getLessonByIdHandler", GetLessonByIdHandler.class);
        return classHandler.handler(getLessonByIdRequest);
    }
}

