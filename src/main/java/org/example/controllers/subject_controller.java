package org.example.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto_request.subject.add.AddSubjectRequest;
import org.example.dto_request.subject.delete.DeleteSubjectRequest;
import org.example.dto_request.subject.edit.EditSubjectRequest;
import org.example.dto_request.subject.get.GetSubjectByIdRequest;
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

    @GetMapping("/getById")
    public String GetSubjectById(@RequestParam("id") int id) throws ParseException, JsonProcessingException {
        classHandler = new GetSubjectByIdHandler();
        GetSubjectByIdRequest getSubjectByIdRequest = new GetSubjectByIdRequest(id);
        return classHandler.handler(getSubjectByIdRequest);
    }

    @PostMapping("/add")
    public String AddSubject(@RequestBody AddSubjectRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new AddSubjectHandler();
        return classHandler.handler(jsonRequest);
    }

    @PostMapping("/edit")
    public String EditSubject(@RequestBody EditSubjectRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new EditSubjectHandler();
        return classHandler.handler(jsonRequest);
    }

    @DeleteMapping("/delete")
    public String DeleteSubject(@RequestBody DeleteSubjectRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new DeleteSubjectHandler();
        return classHandler.handler(jsonRequest);
    }
}
