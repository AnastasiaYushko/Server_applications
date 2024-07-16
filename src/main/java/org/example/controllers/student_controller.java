package org.example.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto_request.student.add.AddStudentRequest;
import org.example.dto_request.student.delete.DeleteStudentRequest;
import org.example.dto_request.student.edit.EditStudentRequest;
import org.example.dto_request.student.get.byGroup.GetStudentsByGroupRequest;
import org.example.dto_request.student.get.byId.GetStudentByIdRequest;
import org.example.handler.IHandler;
import org.example.handler.student.*;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/student")
public class student_controller {
    IHandler classHandler;

    @GetMapping("/getByGroup")
    public String GetStudentsByGroup(@RequestParam("id") int id) throws ParseException, JsonProcessingException {
        classHandler = new GetStudentsByGroupHandler();
        GetStudentsByGroupRequest getStudentsByGroupRequest = new GetStudentsByGroupRequest(id);
        return classHandler.handler(getStudentsByGroupRequest);
    }

    @GetMapping("/getById")
    public String GetStudentById(@RequestParam("id") int id) throws ParseException, JsonProcessingException {
        classHandler = new GetStudentByIdHandler();
        GetStudentByIdRequest getStudentByIdRequest = new GetStudentByIdRequest(id);
        return classHandler.handler(getStudentByIdRequest);
    }

    @PostMapping("/add")
    public String AddStudent(@RequestBody AddStudentRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new AddStudentHandler();
        return classHandler.handler(jsonRequest);
    }

    @PostMapping("/edit")
    public String EditStudent(@RequestBody EditStudentRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new EditStudentHandler();
        return classHandler.handler(jsonRequest);
    }

    @DeleteMapping("/delete")
    public String DeleteStudent(@RequestBody DeleteStudentRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new DeleteStudentHandler();
        return classHandler.handler(jsonRequest);
    }
}
