package org.example.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.SpringConfig;
import org.example.dto_request.studentGroup.add.AddStudentGroupRequest;
import org.example.dto_request.studentGroup.delete.DeleteStudentGroupRequest;
import org.example.dto_request.studentGroup.edit.EditStudentGroupRequest;
import org.example.dto_request.studentGroup.get.GetStudentGroupByIdRequest;
import org.example.handler.IHandler;
import org.example.handler.studentGroup.*;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/studentGroup")
public class studentGroup_controller {
    IHandler classHandler;

    @GetMapping("/get")
    public String GetStudentGroups() throws ParseException, JsonProcessingException {
        classHandler = SpringConfig.getContext().getBean("getStudentGroupsHandler", GetStudentGroupsHandler.class);
        return classHandler.handler(null);
    }

    @GetMapping("/getGyId")
    public String GetStudentGroupById(@RequestParam("id") int id) throws ParseException, JsonProcessingException {
        GetStudentGroupByIdRequest getStudentGroupByIdRequest = SpringConfig.getContext().getBean("getStudentGroupByIdRequest", GetStudentGroupByIdRequest.class);
        getStudentGroupByIdRequest.setId(id);

        classHandler = SpringConfig.getContext().getBean("getStudentGroupBydHandler", GetStudentGroupByIdHandler.class);
        return classHandler.handler(getStudentGroupByIdRequest);
    }

    @PostMapping("/add")
    public String AddStudentGroup(@RequestBody AddStudentGroupRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = SpringConfig.getContext().getBean("addStudentGroupHandler", AddStudentGroupHandler.class);
        return classHandler.handler(jsonRequest);
    }

    @PostMapping("/edit")
    public String EditStudentGroup(@RequestBody EditStudentGroupRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = SpringConfig.getContext().getBean("editStudentGroupHandler", EditStudentGroupHandler.class);
        return classHandler.handler(jsonRequest);
    }

    @DeleteMapping("/delete")
    public String DeleteStudentGroup(@RequestParam("id") int id) throws ParseException, JsonProcessingException {
        DeleteStudentGroupRequest deleteStudentGroupRequest =  SpringConfig.getContext().getBean("deleteStudentGroupRequest",DeleteStudentGroupRequest.class);
        deleteStudentGroupRequest.setId(id);

        classHandler = SpringConfig.getContext().getBean("deleteStudentGroupHandler", DeleteStudentGroupHandler.class);
        return classHandler.handler(deleteStudentGroupRequest);
    }
}
