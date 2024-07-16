package org.example.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
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
        classHandler = new AddLessonHandler();
        return classHandler.handler(jsonRequest);
    }

    @PostMapping("/edit")
    public String EditLesson(@RequestBody EditLessonRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new EditLessonHandler();
        return classHandler.handler(jsonRequest);
    }

    @DeleteMapping("/deleteById")
    public String DeleteLessonById(@RequestBody DeleteLessonByIdRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new DeleteLessonByIdHandler();
        return classHandler.handler(jsonRequest);
    }

    @DeleteMapping("/deleteByGroup")
    public String DeleteLessonByGroup(@RequestBody DeleteLessonsByGroupRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new DeleteLessonsByGroupHandler();
        return classHandler.handler(jsonRequest);
    }

    @DeleteMapping("/deleteByTeacher")
    public String DeleteLessonByTeacher(@RequestBody DeleteLessonsByTeacherRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new DeleteLessonsByTeacherHandler();
        return classHandler.handler(jsonRequest);
    }

    @GetMapping("/getByTeacher")
    public String GetLessonByTeacher(@RequestParam("id") int id, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) throws ParseException, JsonProcessingException {
        classHandler = new GetLessonByTeacherHandler();
        GetLessonsByTeacherRequest getLessonsByTeacherRequest = new GetLessonsByTeacherRequest(startDate, endDate, id);
        return classHandler.handler(getLessonsByTeacherRequest);
    }

    @GetMapping("/getByGroup")
    public String GetLessonByGroup(@RequestParam("id") int id, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) throws ParseException, JsonProcessingException {
        classHandler = new GetLessonsByGroupHandler();
        GetLessonsByGroupRequest getLessonsByGroupRequest = new GetLessonsByGroupRequest(startDate, endDate, id);
        return classHandler.handler(getLessonsByGroupRequest);
    }

    @GetMapping("/getById")
    public String GetLessonById(@RequestParam("id") int id) throws ParseException, JsonProcessingException {
        classHandler = new GetLessonByIdHandler();
        GetLessonByIdRequest getLessonByIdRequest = new GetLessonByIdRequest(id);
        return classHandler.handler(getLessonByIdRequest);
    }
}

