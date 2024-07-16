package org.example.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto_request.teacher.add.AddTeacherRequest;
import org.example.dto_request.teacher.delete.DeleteTeacherRequest;
import org.example.dto_request.teacher.edit.EditTeacherRequest;
import org.example.dto_request.teacher.get.GetTeacherByIdRequest;
import org.example.handler.IHandler;
import org.example.handler.teacher.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping(value = "/teacher", consumes = MediaType.APPLICATION_JSON_VALUE)
public class teacher_controller {
    IHandler classHandler;

    @GetMapping("/get")
    public String GetTeachers() throws ParseException, JsonProcessingException {
        classHandler = new GetTeachersHandler();
        return classHandler.handler(null);
    }

    @GetMapping("/getById")
    public String GetTeacherById(@RequestParam("id") int id) throws JsonProcessingException, ParseException {
        classHandler = new GetTeacherByIdHandler();
        GetTeacherByIdRequest getTeacherByIdRequest = new GetTeacherByIdRequest(id);
        return classHandler.handler(getTeacherByIdRequest);
    }

    @PostMapping("/add")
    public String AddTeacher(@RequestBody AddTeacherRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new AddTeacherHandler();
        return classHandler.handler(jsonRequest);
    }

    @PostMapping("/edit")
    public String EditTeacher(@RequestBody EditTeacherRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new EditTeacherHandler();
        return classHandler.handler(jsonRequest);
    }

    @DeleteMapping("/delete")
    public String deleteTeacher(@RequestParam("id") int id) throws ParseException, JsonProcessingException {
        classHandler = new DeleteTeacherHandler();
        DeleteTeacherRequest deleteTeacherRequest = new DeleteTeacherRequest(id);
        return classHandler.handler(deleteTeacherRequest);
    }
}
