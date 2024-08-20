package org.example.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.example.ResponseEntity;
import org.example.SpringConfig;
import org.example.dto.dtoRequest.teacher.AddTeacherRequest;
import org.example.dto.dtoRequest.teacher.DeleteTeacherRequest;
import org.example.dto.dtoRequest.teacher.EditTeacherRequest;
import org.example.dto.dtoRequest.teacher.GetTeacherByIdRequest;
import org.example.dto.dtoResponse.teacher.AddTeacherResponse;
import org.example.dto.dtoResponse.teacher.GetTeacherByIdResponse;
import org.example.dto.dtoResponse.teacher.GetTeachersResponse;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;
import org.example.services.serviceInterfaceImpl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/teacher")
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

    @GetMapping("/getById")
    public ResponseEntity<GetTeacherByIdResponse> GetTeacherById(@Valid @RequestParam("id") int id) throws EntityNotFoundInDataBase {
        GetTeacherByIdRequest getTeacherByIdRequest = SpringConfig.getContext().getBean("getTeacherByIdRequest", GetTeacherByIdRequest.class);
        getTeacherByIdRequest.setId(id);

        GetTeacherByIdResponse dataResponse = teacherService.getTeacherById(getTeacherByIdRequest);
        return new ResponseEntity<>(dataResponse, HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<AddTeacherResponse> AddTeacher(@Valid @RequestBody AddTeacherRequest jsonRequest) throws AddEntityMatchData {
        AddTeacherResponse dataResponse = teacherService.addTeacher(jsonRequest);
        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<String> EditTeacher(@Valid @RequestBody EditTeacherRequest jsonRequest) throws StupidChanges, ChangesEntityLeadToConflict, EntityNotFoundInDataBase {
        String dataResponse = teacherService.editTeacher(jsonRequest);
        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteTeacher(@Valid @RequestParam("id") @Positive int id) throws EntityNotFoundInDataBase {
        DeleteTeacherRequest deleteTeacherRequest = SpringConfig.getContext().getBean("deleteTeacherRequest", DeleteTeacherRequest.class);
        deleteTeacherRequest.setId(id);

        String dataResponse = teacherService.deleteTeacher(deleteTeacherRequest);
        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }
}
