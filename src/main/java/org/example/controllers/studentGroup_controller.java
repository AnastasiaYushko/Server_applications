package org.example.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
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

    @PostMapping("/getGyId")
    public String GetStudentGroupById(@RequestBody String jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new GetStudentGroupsHandler();
        return classHandler.handler(jsonRequest);
    }

    @PostMapping("/add")
    public String AddStudentGroup(@RequestBody String jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new AddStudentGroupHandler();
        return classHandler.handler(jsonRequest);
    }

    @PostMapping("/edit")
    public String EditStudentGroup(@RequestBody String jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new EditStudentGroupHandler();
        return classHandler.handler(jsonRequest);
    }

    @DeleteMapping("/delete")
    public String DeleteStudentGroup(@RequestBody String jsonRequest) throws ParseException, JsonProcessingException {
        classHandler = new DeleteStudentGroupHandler();
        return classHandler.handler(jsonRequest);
    }
}
