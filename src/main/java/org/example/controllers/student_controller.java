package org.example.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.SpringConfig;
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
        GetStudentsByGroupRequest getStudentsByGroupRequest = SpringConfig.getContext().getBean("getStudentsByGroupRequest", GetStudentsByGroupRequest.class);
        getStudentsByGroupRequest.setGroupId(id);

        classHandler = SpringConfig.getContext().getBean("getStudentsByGroupHandler", GetStudentsByGroupHandler.class);
        return classHandler.handler(getStudentsByGroupRequest);
    }

    @GetMapping("/getById")
    public String GetStudentById(@RequestParam("id") int id) throws ParseException, JsonProcessingException {
        GetStudentByIdRequest getStudentByIdRequest = SpringConfig.getContext().getBean("getStudentByIdRequest", GetStudentByIdRequest.class);
        getStudentByIdRequest.setStudentId(id);

        classHandler = SpringConfig.getContext().getBean("getStudentByIdHandler", GetStudentByIdHandler.class);
        return classHandler.handler(getStudentByIdRequest);
    }

    @PostMapping("/add")
    public String AddStudent(@RequestBody AddStudentRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = SpringConfig.getContext().getBean("addStudentHandler", AddStudentHandler.class);
        return classHandler.handler(jsonRequest);
    }

    @PostMapping("/edit")
    public String EditStudent(@RequestBody EditStudentRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = SpringConfig.getContext().getBean("editStudentHandler", EditStudentHandler.class);
        return classHandler.handler(jsonRequest);
    }

    @DeleteMapping("/delete")
    public String DeleteStudent(@RequestParam("id") int id) throws ParseException, JsonProcessingException {
        DeleteStudentRequest deleteStudentRequest = SpringConfig.getContext().getBean("deleteStudentRequest",DeleteStudentRequest.class);
        deleteStudentRequest.setStudentId(id);

        classHandler = SpringConfig.getContext().getBean("deleteStudentHandler", DeleteStudentHandler.class);
        return classHandler.handler(deleteStudentRequest);
    }
}
