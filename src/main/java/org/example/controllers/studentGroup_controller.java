package org.example.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto_request.studentGroup.add.AddStudentGroupRequest;
import org.example.dto_request.studentGroup.delete.DeleteStudentGroupRequest;
import org.example.dto_request.studentGroup.edit.EditStudentGroupRequest;
import org.example.dto_request.studentGroup.get.GetStudentGroupByIdRequest;
import org.example.handler.IHandler;
import org.example.handler.studentGroup.AddStudentGroupHandler;
import org.example.handler.studentGroup.DeleteStudentGroupHandler;
import org.example.handler.studentGroup.EditStudentGroupHandler;
import org.example.handler.studentGroup.GetStudentGroupsHandler;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/studentGroup")
public class studentGroup_controller {
    IHandler classHandler;

    @GetMapping("/get")
    public String GetStudentGroups() throws ParseException, JsonProcessingException {
        classHandler = new GetStudentGroupsHandler();
        return classHandler.handler(null);
    }

    @GetMapping("/getGyId")
    public String GetStudentGroupById(@RequestParam("id") int id) throws ParseException, JsonProcessingException {
        classHandler = new GetStudentGroupsHandler();
        GetStudentGroupByIdRequest getStudentGroupByIdRequest = new GetStudentGroupByIdRequest(id);
        return classHandler.handler(getStudentGroupByIdRequest);
    }

    @PostMapping("/add")
    public String AddStudentGroup(@RequestBody AddStudentGroupRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new AddStudentGroupHandler();
        return classHandler.handler(jsonRequest);
    }

    @PostMapping("/edit")
    public String EditStudentGroup(@RequestBody EditStudentGroupRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new EditStudentGroupHandler();
        return classHandler.handler(jsonRequest);
    }

    @DeleteMapping("/delete")
    public String DeleteStudentGroup(@RequestBody DeleteStudentGroupRequest jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new DeleteStudentGroupHandler();
        return classHandler.handler(jsonRequest);
    }
}
