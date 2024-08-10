package org.example.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.SpringConfig;
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
        classHandler = SpringConfig.getContext().getBean("getSubjectsHandler", GetSubjectsHandler.class);
        return classHandler.handler(null);
    }

    @GetMapping("/getById")
    public String GetSubjectById(@RequestParam("id") int id) throws ParseException, JsonProcessingException {
        GetSubjectByIdRequest getSubjectByIdRequest = SpringConfig.getContext().getBean("getSubjectByIdRequest", GetSubjectByIdRequest.class);
        getSubjectByIdRequest.setId(id);

        classHandler = SpringConfig.getContext().getBean("getSubjectByIdHandler", GetSubjectByIdHandler.class);
        return classHandler.handler(getSubjectByIdRequest);
    }

    @PostMapping("/add")
    public String AddSubject(@RequestBody AddSubjectRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = SpringConfig.getContext().getBean("addSubjectHandler", AddSubjectHandler.class);
        return classHandler.handler(jsonRequest);
    }

    @PostMapping("/edit")
    public String EditSubject(@RequestBody EditSubjectRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = SpringConfig.getContext().getBean("editSubjectHandler", EditSubjectHandler.class);
        return classHandler.handler(jsonRequest);
    }

    @DeleteMapping("/delete")
    public String DeleteSubject(@RequestBody DeleteSubjectRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = SpringConfig.getContext().getBean("deleteSubjectHandler", DeleteSubjectHandler.class);
        return classHandler.handler(jsonRequest);
    }
}
