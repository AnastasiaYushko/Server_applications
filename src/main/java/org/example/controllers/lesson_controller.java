package org.example.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.handler.IHandler;
import org.example.handler.lesson.*;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/lesson")
public class lesson_controller {
    IHandler classHandler;

    @PostMapping("/add")
    public String AddLesson(@RequestBody String jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new AddLessonHandler();
        return classHandler.handler(jsonRequest);
    }

    @PostMapping("/edit")
    public String EditLesson(@RequestBody String jsonRequest)throws ParseException, JsonProcessingException {
        classHandler = new EditLessonHandler();
        return classHandler.handler(jsonRequest);
    }

    @DeleteMapping("/deleteById")
    public String DeleteLessonById(@RequestBody String jsonRequest)throws ParseException, JsonProcessingException {
        classHandler = new DeleteLessonByIdHandler();
        return classHandler.handler(jsonRequest);
    }

    @DeleteMapping("/deleteByGroup")
    public String DeleteLessonByGroup(@RequestBody String jsonRequest)throws ParseException, JsonProcessingException {
        classHandler = new DeleteLessonsByGroupHandler();
        return classHandler.handler(jsonRequest);
    }

    @DeleteMapping("/deleteByTeacher")
    public String DeleteLessonByTeacher(@RequestBody String jsonRequest)throws ParseException, JsonProcessingException {
        classHandler = new DeleteLessonsByTeacherHandler();
        return classHandler.handler(jsonRequest);
    }

    @PostMapping("/getByTeacher")
    public String GetLessonByTeacher(@RequestBody String jsonRequest)throws ParseException, JsonProcessingException {
        classHandler = new GetLessonByTeacherHandler();
        return classHandler.handler(jsonRequest);
    }

    @PostMapping("/getByGroup")
    public String GetLessonByGroup(@RequestBody String jsonRequest)throws ParseException, JsonProcessingException {
        classHandler = new GetLessonsByGroupHandler();
        return classHandler.handler(jsonRequest);
    }

    @PostMapping("/getById")
    public String GetLessonById(@RequestBody String jsonRequest)throws ParseException, JsonProcessingException {
        classHandler = new GetLessonByIdHandler();
        return classHandler.handler(jsonRequest);
    }
}

