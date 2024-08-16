package org.example.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.SpringConfig;
import org.example.dto_request.subject.add.AddSubjectRequest;
import org.example.dto_request.subject.delete.DeleteSubjectRequest;
import org.example.dto_request.subject.edit.EditSubjectRequest;
import org.example.dto_request.subject.get.GetSubjectByIdRequest;
import org.example.handler.IHandler;
import org.example.handler.subject.*;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.text.ParseException;

@RestController
@RequestMapping(value = "/subject", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class subject_controller {
    IHandler classHandler;

    @GetMapping("/get")
    public String GetSubjects() throws ParseException, JsonProcessingException {
        classHandler = SpringConfig.getContext().getBean("getSubjectsHandler", GetSubjectsHandler.class);
        return classHandler.handler(null);
    }

    @GetMapping("/getById")
    public String GetSubjectById(@Valid @RequestParam("id") @Positive int id) throws ParseException, JsonProcessingException {
        GetSubjectByIdRequest getSubjectByIdRequest = SpringConfig.getContext().getBean("getSubjectByIdRequest", GetSubjectByIdRequest.class);
        getSubjectByIdRequest.setId(id);

        classHandler = SpringConfig.getContext().getBean("getSubjectByIdHandler", GetSubjectByIdHandler.class);
        return classHandler.handler(getSubjectByIdRequest);
    }

    @PostMapping("/add")
    public String AddSubject(@Valid @RequestBody AddSubjectRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = SpringConfig.getContext().getBean("addSubjectHandler", AddSubjectHandler.class);
        return classHandler.handler(jsonRequest);
    }

    @PostMapping("/edit")
    public String EditSubject(@Valid @RequestBody EditSubjectRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = SpringConfig.getContext().getBean("editSubjectHandler", EditSubjectHandler.class);
        return classHandler.handler(jsonRequest);
    }

    @DeleteMapping("/delete")
    public String DeleteSubject(@Valid @RequestParam("id") @Positive int id) throws ParseException, JsonProcessingException {
        DeleteSubjectRequest deleteSubjectRequest = SpringConfig.getContext().getBean("deleteSubjectRequest", DeleteSubjectRequest.class);
        deleteSubjectRequest.setId(id);

        classHandler = SpringConfig.getContext().getBean("deleteSubjectHandler", DeleteSubjectHandler.class);
        return classHandler.handler(deleteSubjectRequest);
    }
}
