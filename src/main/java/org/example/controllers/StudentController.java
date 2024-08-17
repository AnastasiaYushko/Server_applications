package org.example.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

import org.example.SpringConfig;
import org.example.dtoRequest.student.*;
import org.example.dtoResponse.student.AddStudentResponse;
import org.example.dtoResponse.student.GetStudentByIdResponse;
import org.example.dtoResponse.student.GetStudentsByGroupResponse;
import org.example.ResponseEntity;
import org.example.services.serviceInterfaceImpl.StudentServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import javax.xml.rpc.ServiceException;

@RestController
@RequestMapping(value = "/student", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class StudentController {

    private final StudentServiceImpl studentService;

    @Autowired
    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getByGroup")
    public ResponseEntity<?> GetStudentsByGroup(@Valid @RequestParam("id") @Positive int id) {
        GetStudentsByGroupRequest getStudentsByGroupRequest = SpringConfig.getContext().getBean("getStudentsByGroupRequest", GetStudentsByGroupRequest.class);
        getStudentsByGroupRequest.setGroupId(id);
        try {
            GetStudentsByGroupResponse getStudentsByGroupResponse = studentService.getStudentsByGroup(getStudentsByGroupRequest);
            return new ResponseEntity<>(getStudentsByGroupResponse, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getById")
    public ResponseEntity<?> GetStudentById(@Valid @RequestParam("id") @Positive int id) {
        GetStudentByIdRequest getStudentByIdRequest = SpringConfig.getContext().getBean("getStudentByIdRequest", GetStudentByIdRequest.class);
        getStudentByIdRequest.setStudentId(id);
        try {
            GetStudentByIdResponse studentResponse = studentService.getStudentById(getStudentByIdRequest);
            return new ResponseEntity<>(studentResponse, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> AddStudent(@Valid @RequestBody AddStudentRequest jsonRequest) {
        try {
            AddStudentResponse addStudentResponse = studentService.addStudent(jsonRequest);
            return new ResponseEntity<>(addStudentResponse, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/edit")
    public ResponseEntity<?> EditStudent(@Valid @RequestBody EditStudentRequest jsonRequest) {
        try {
            String editStudentResponse = studentService.editStudent(jsonRequest);
            return new ResponseEntity<>(editStudentResponse, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> DeleteStudent(@Valid @RequestParam("id") @Positive int id) {
        DeleteStudentRequest deleteStudentRequest = SpringConfig.getContext().getBean("deleteStudentRequest", DeleteStudentRequest.class);
        deleteStudentRequest.setStudentId(id);
        try {
            String data = studentService.deleteStudent(deleteStudentRequest);
            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
