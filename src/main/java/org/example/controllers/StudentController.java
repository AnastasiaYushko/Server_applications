package org.example.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.example.SpringConfig;
import org.example.dto.dtoRequest.student.*;
import org.example.dto.dtoResponse.student.AddStudentResponse;
import org.example.dto.dtoResponse.student.GetStudentByIdResponse;
import org.example.dto.dtoResponse.student.GetStudentsByGroupResponse;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;
import org.example.services.serviceInterfaceImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/student")
@Validated
public class StudentController {

    private final StudentServiceImpl studentService;

    @Autowired
    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getByGroup")
    public ResponseEntity<GetStudentsByGroupResponse> GetStudentsByGroup(@Valid @RequestParam("id") @Positive int id) throws EntityNotFoundInDataBase {
        GetStudentsByGroupRequest getStudentsByGroupRequest = SpringConfig.getContext().getBean("getStudentsByGroupRequest", GetStudentsByGroupRequest.class);
        getStudentsByGroupRequest.setGroupId(id);

        GetStudentsByGroupResponse getStudentsByGroupResponse = studentService.getStudentsByGroup(getStudentsByGroupRequest);
        return new ResponseEntity<>(getStudentsByGroupResponse, HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<GetStudentByIdResponse> GetStudentById(@Valid @RequestParam("id") @Positive int id) throws EntityNotFoundInDataBase {
        GetStudentByIdRequest getStudentByIdRequest = SpringConfig.getContext().getBean("getStudentByIdRequest", GetStudentByIdRequest.class);
        getStudentByIdRequest.setStudentId(id);

        GetStudentByIdResponse studentResponse = studentService.getStudentById(getStudentByIdRequest);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<AddStudentResponse> AddStudent(@Valid @RequestBody AddStudentRequest jsonRequest) throws EntityNotFoundInDataBase, AddEntityMatchData {
        AddStudentResponse addStudentResponse = studentService.addStudent(jsonRequest);
        return new ResponseEntity<>(addStudentResponse, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<String> EditStudent(@Valid @RequestBody EditStudentRequest jsonRequest) throws StupidChanges, ChangesEntityLeadToConflict, EntityNotFoundInDataBase {
        String editStudentResponse = studentService.editStudent(jsonRequest);
        return new ResponseEntity<>(editStudentResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> DeleteStudent(@Valid @RequestParam("id") @Positive int id) throws EntityNotFoundInDataBase {
        DeleteStudentRequest deleteStudentRequest = SpringConfig.getContext().getBean("deleteStudentRequest", DeleteStudentRequest.class);
        deleteStudentRequest.setStudentId(id);

        String data = studentService.deleteStudent(deleteStudentRequest);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
