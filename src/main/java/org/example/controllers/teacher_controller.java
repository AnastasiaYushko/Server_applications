package org.example.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.SpringConfig;
import org.example.dto_request.teacher.add.AddTeacherRequest;
import org.example.dto_request.teacher.delete.DeleteTeacherRequest;
import org.example.dto_request.teacher.edit.EditTeacherRequest;
import org.example.dto_request.teacher.get.GetTeacherByIdRequest;
import org.example.handler.IHandler;
import org.example.handler.teacher.*;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.text.ParseException;

@RestController
@RequestMapping(value = "/teacher", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class teacher_controller {
    IHandler classHandler;

    @GetMapping("/get")
    public String GetTeachers() throws ParseException, JsonProcessingException {
        classHandler = SpringConfig.getContext().getBean("getTeachersHandler", GetTeachersHandler.class);
        return classHandler.handler(null);
    }

    @GetMapping("/getById")
    public String GetTeacherById(@Valid @RequestParam("id") @Positive int id) throws JsonProcessingException, ParseException {
        classHandler = SpringConfig.getContext().getBean("getTeacherByIdHandler", GetTeacherByIdHandler.class);
        GetTeacherByIdRequest getTeacherByIdRequest = SpringConfig.getContext().getBean("getTeacherByIdRequest", GetTeacherByIdRequest.class);
        getTeacherByIdRequest.setId(id);
        return classHandler.handler(getTeacherByIdRequest);
    }

    @PostMapping("/add")
    public String AddTeacher(@Valid @RequestBody AddTeacherRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = SpringConfig.getContext().getBean("addTeacherHandler", AddTeacherHandler.class);
        return classHandler.handler(jsonRequest);
    }

    @PostMapping("/edit")
    public String EditTeacher(@Valid @RequestBody EditTeacherRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = SpringConfig.getContext().getBean("editTeacherHandler", EditTeacherHandler.class);
        return classHandler.handler(jsonRequest);
    }

    @DeleteMapping("/delete")
    public String deleteTeacher(@Valid @RequestParam("id") @Positive int id) throws ParseException, JsonProcessingException {
        DeleteTeacherRequest deleteTeacherRequest = SpringConfig.getContext().getBean("deleteTeacherRequest", DeleteTeacherRequest.class);
        deleteTeacherRequest.setId(id);

        classHandler = SpringConfig.getContext().getBean("deleteTeacherHandler", DeleteTeacherHandler.class);
        return classHandler.handler(deleteTeacherRequest);
    }
}
