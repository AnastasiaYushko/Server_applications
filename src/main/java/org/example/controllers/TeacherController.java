package org.example.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

import org.example.SpringConfig;
import org.example.dtoRequest.teacher.AddTeacherRequest;
import org.example.dtoRequest.teacher.DeleteTeacherRequest;
import org.example.dtoRequest.teacher.EditTeacherRequest;
import org.example.dtoRequest.teacher.GetTeacherByIdRequest;
import org.example.dtoResponse.teacher.AddTeacherResponse;
import org.example.dtoResponse.teacher.GetTeacherByIdResponse;
import org.example.dtoResponse.teacher.GetTeachersResponse;
import org.example.ResponseEntity;
import org.example.services.serviceInterfaceImpl.TeacherServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.xml.rpc.ServiceException;

@RestController
@RequestMapping(value = "/teacher", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class TeacherController {

    private final TeacherServiceImpl teacherService;

    @Autowired
    public TeacherController(TeacherServiceImpl teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/get")
    public ResponseEntity<GetTeachersResponse> GetTeachers() {
        GetTeachersResponse dataResponse = teacherService.getTeachers();
        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> GetTeacherById(@Valid @PathVariable("id") GetTeacherByIdRequest getTeacherByIdRequest) {
        try {
            GetTeacherByIdResponse dataResponse = teacherService.getTeacherById(getTeacherByIdRequest);
            return new ResponseEntity<>(dataResponse, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> AddTeacher(@Valid @RequestBody AddTeacherRequest jsonRequest) {
        try {
            AddTeacherResponse dataResponse = teacherService.addTeacher(jsonRequest);
            return new ResponseEntity<>(dataResponse, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/edit")
    public ResponseEntity<String> EditTeacher(@Valid @RequestBody EditTeacherRequest jsonRequest) {
        try {
            String dataResponse = teacherService.editTeacher(jsonRequest);
            return new ResponseEntity<>(dataResponse, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteTeacher(@Valid @RequestParam("id") @Positive int id) {
        DeleteTeacherRequest deleteTeacherRequest = SpringConfig.getContext().getBean("deleteTeacherRequest", DeleteTeacherRequest.class);
        deleteTeacherRequest.setId(id);
        try {
            String dataResponse = teacherService.deleteTeacher(deleteTeacherRequest);
            return new ResponseEntity<>(dataResponse, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
