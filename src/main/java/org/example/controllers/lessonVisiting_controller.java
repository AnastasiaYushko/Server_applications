package org.example.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.handler.IHandler;
import org.example.handler.lessonVisiting.*;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/lessonVisiting")
public class lessonVisiting_controller {
    IHandler classHandler;

    @PostMapping("/add")
    public String AddLessonVisiting(@RequestBody String jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new AddLessonVisitingHandler();
        return classHandler.handler(jsonRequest);
    }

    @PostMapping("/edit")
    public String EditLessonVisiting(@RequestBody String jsonRequest)throws ParseException, JsonProcessingException {
        classHandler = new EditLessonVisitingHandler();
        return classHandler.handler(jsonRequest);
    }

    @DeleteMapping("/deleteById")
    public String DeleteLessonVisitingById(@RequestBody String jsonRequest)throws ParseException, JsonProcessingException {
        classHandler = new DeleteLessonVisitingByIdHandler();
        return classHandler.handler(jsonRequest);
    }

    @DeleteMapping("/deleteByLessonId")
    public String DeleteLessonVisitingByLessonId(@RequestBody String jsonRequest)throws ParseException, JsonProcessingException {
        classHandler = new DeleteLessonVisitingByLessonIdHandler();
        return classHandler.handler(jsonRequest);
    }

    @PostMapping("/getById")
    public String GetLessonVisitingById(@RequestBody String jsonRequest)throws ParseException, JsonProcessingException {
        classHandler = new GetLessonVisitingByIdHandler();
        return classHandler.handler(jsonRequest);
    }

    @PostMapping("/getByLessonId")
    public String GetLessonVisitingByLessonId(@RequestBody String jsonRequest)throws ParseException, JsonProcessingException {
        classHandler = new GetLessonVisitingByLessonIdHandler();
        return classHandler.handler(jsonRequest);
    }
}


