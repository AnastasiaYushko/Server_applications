package org.example.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.handler.IHandler;
import org.example.handler.subject.*;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/subject")
public class subject_controller {
    IHandler classHandler;

    @GetMapping("/get")
    public String GetSubjects() throws ParseException, JsonProcessingException {
        classHandler = new GetSubjectsHandler();
        return classHandler.handler(null);
    }

    @PostMapping("/getById")
    public String GetSubjectById(@RequestBody String jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new GetSubjectByIdHandler();
        return classHandler.handler(jsonRequest);
    }

    @PostMapping("/add")
    public String AddSubject(@RequestBody String jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new AddSubjectHandler();
        return classHandler.handler(jsonRequest);
    }

    @PostMapping("/edit")
    public String EditSubject(@RequestBody String jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new EditSubjectHandler();
        return classHandler.handler(jsonRequest);
    }

    @DeleteMapping("/delete")
    public String DeleteSubject(@RequestBody String jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new DeleteSubjectHandler();
        return classHandler.handler(jsonRequest);
    }
}
