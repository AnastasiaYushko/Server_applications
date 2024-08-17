package org.example.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.example.SpringConfig;
import org.example.dto_request.studentGroup.AddStudentGroupRequest;
import org.example.dto_request.studentGroup.DeleteStudentGroupRequest;
import org.example.dto_request.studentGroup.EditStudentGroupRequest;
import org.example.dto_request.studentGroup.GetStudentGroupByIdRequest;
import org.example.handler.IHandler;
import org.example.handler.studentGroup.*;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping(value = "/studentGroup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class studentGroup_controller {
    IHandler classHandler;

    @GetMapping("/get")
    public String GetStudentGroups() throws ParseException, JsonProcessingException {
        classHandler = SpringConfig.getContext().getBean("getStudentGroupsHandler", GetStudentGroupsHandler.class);
        return classHandler.handler(null);
    }

    @GetMapping("/getGyId")
    public String GetStudentGroupById(@Valid @RequestParam("id") @Positive int id) throws ParseException, JsonProcessingException {
        GetStudentGroupByIdRequest getStudentGroupByIdRequest = SpringConfig.getContext().getBean("getStudentGroupByIdRequest", GetStudentGroupByIdRequest.class);
        getStudentGroupByIdRequest.setId(id);

        classHandler = SpringConfig.getContext().getBean("getStudentGroupByIdHandler", GetStudentGroupByIdHandler.class);
        return classHandler.handler(getStudentGroupByIdRequest);
    }

    @PostMapping("/add")
    public String AddStudentGroup(@Valid @RequestBody AddStudentGroupRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = SpringConfig.getContext().getBean("addStudentGroupHandler", AddStudentGroupHandler.class);
        return classHandler.handler(jsonRequest);
    }

    @PostMapping("/edit")
    public String EditStudentGroup(@Valid @RequestBody EditStudentGroupRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = SpringConfig.getContext().getBean("editStudentGroupHandler", EditStudentGroupHandler.class);
        return classHandler.handler(jsonRequest);
    }

    @DeleteMapping("/delete")
    public String DeleteStudentGroup(@Valid @RequestParam("id") @Positive int id) throws ParseException, JsonProcessingException {
        DeleteStudentGroupRequest deleteStudentGroupRequest = SpringConfig.getContext().getBean("deleteStudentGroupRequest", DeleteStudentGroupRequest.class);
        deleteStudentGroupRequest.setId(id);

        classHandler = SpringConfig.getContext().getBean("deleteStudentGroupHandler", DeleteStudentGroupHandler.class);
        return classHandler.handler(deleteStudentGroupRequest);
    }
}
