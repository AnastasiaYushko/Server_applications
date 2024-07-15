package org.example.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.handler.IHandler;
import org.example.handler.student.*;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/student")
public class student_controller {
    IHandler classHandler;

    @PostMapping("/getByGroup")
    public String GetStudentsByGroup(@RequestBody String jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new GetStudentsByGroupHandler();
        return classHandler.handler(jsonRequest);
    }

    @PostMapping("/getById")
    public String GetStudentById(@RequestBody String jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new GetStudentByIdHandler();
        return classHandler.handler(jsonRequest);
    }

    @PostMapping("/add")
    public String AddStudent(@RequestBody String jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new AddStudentHandler();
        return classHandler.handler(jsonRequest);
    }

    @PostMapping("/edit")
    public String EditStudent(@RequestBody String jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new EditStudentHandler();
        return classHandler.handler(jsonRequest);
    }

    @DeleteMapping("/delete")
    public String DeleteStudent(@RequestBody String jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new DeleteStudentHandler();
        return classHandler.handler(jsonRequest);
    }
}
