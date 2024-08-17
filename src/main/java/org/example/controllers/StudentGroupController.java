package org.example.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

import org.example.SpringConfig;
import org.example.dto.dtoRequest.studentGroup.AddStudentGroupRequest;
import org.example.dto.dtoRequest.studentGroup.DeleteStudentGroupRequest;
import org.example.dto.dtoRequest.studentGroup.EditStudentGroupRequest;
import org.example.dto.dtoRequest.studentGroup.GetStudentGroupByIdRequest;
import org.example.dto.dtoResponse.studentGroup.AddStudentGroupResponse;
import org.example.dto.dtoResponse.studentGroup.GetStudentGroupByIdResponse;
import org.example.dto.dtoResponse.studentGroup.GetStudentGroupsResponse;
import org.example.ResponseEntity;
import org.example.services.serviceInterfaceImpl.GroupStudentServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import javax.xml.rpc.ServiceException;

@RestController
@RequestMapping(value = "/studentGroup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class StudentGroupController {

    private final GroupStudentServiceImpl groupStudentService;

    @Autowired
    public StudentGroupController(GroupStudentServiceImpl groupStudentService) {
        this.groupStudentService = groupStudentService;
    }

    @GetMapping("/get")
    public ResponseEntity<GetStudentGroupsResponse> GetStudentGroups() {
        GetStudentGroupsResponse getStudentGroupsResponse = groupStudentService.getStudentGroups();
        return new ResponseEntity<>(getStudentGroupsResponse, HttpStatus.OK);
    }

    @GetMapping("/getGyId")
    public ResponseEntity<?> GetStudentGroupById(@Valid @RequestParam("id") @Positive int id) {
        GetStudentGroupByIdRequest getStudentGroupByIdRequest = SpringConfig.getContext().getBean("getStudentGroupByIdRequest", GetStudentGroupByIdRequest.class);
        getStudentGroupByIdRequest.setId(id);
        try {
            GetStudentGroupByIdResponse getStudentGroupByIdResponse = groupStudentService.getStudentGroupById(getStudentGroupByIdRequest);
            return new ResponseEntity<>(getStudentGroupByIdResponse, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> AddStudentGroup(@Valid @RequestBody AddStudentGroupRequest jsonRequest) {
        try {
            AddStudentGroupResponse addStudentGroupResponse = groupStudentService.addStudentGroup(jsonRequest);
            return new ResponseEntity<>(addStudentGroupResponse, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/edit")
    public ResponseEntity<?> EditStudentGroup(@Valid @RequestBody EditStudentGroupRequest jsonRequest) {
        try {
            String editStudentGroupResponse = groupStudentService.editStudentGroup(jsonRequest);
            return new ResponseEntity<>(editStudentGroupResponse, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> DeleteStudentGroup(@Valid @RequestParam("id") @Positive int id) {
        DeleteStudentGroupRequest deleteStudentGroupRequest = SpringConfig.getContext().getBean("deleteStudentGroupRequest", DeleteStudentGroupRequest.class);
        deleteStudentGroupRequest.setId(id);
        try {
            String dataResponse = groupStudentService.deleteStudentGroup(deleteStudentGroupRequest);
            return new ResponseEntity<>(dataResponse, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
