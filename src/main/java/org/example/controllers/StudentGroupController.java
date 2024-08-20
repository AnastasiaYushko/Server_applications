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
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;
import org.example.services.serviceInterfaceImpl.GroupStudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/studentGroup")
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
    public ResponseEntity<GetStudentGroupByIdResponse> GetStudentGroupById(@Valid @RequestParam("id") @Positive int id) throws EntityNotFoundInDataBase {
        GetStudentGroupByIdRequest getStudentGroupByIdRequest = SpringConfig.getContext().getBean("getStudentGroupByIdRequest", GetStudentGroupByIdRequest.class);
        getStudentGroupByIdRequest.setId(id);

        GetStudentGroupByIdResponse getStudentGroupByIdResponse = groupStudentService.getStudentGroupById(getStudentGroupByIdRequest);
        return new ResponseEntity<>(getStudentGroupByIdResponse, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<AddStudentGroupResponse> AddStudentGroup(@Valid @RequestBody AddStudentGroupRequest jsonRequest) throws AddEntityMatchData {
        AddStudentGroupResponse addStudentGroupResponse = groupStudentService.addStudentGroup(jsonRequest);
        return new ResponseEntity<>(addStudentGroupResponse, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<String> EditStudentGroup(@Valid @RequestBody EditStudentGroupRequest jsonRequest) throws StupidChanges, ChangesEntityLeadToConflict, EntityNotFoundInDataBase {
        String editStudentGroupResponse = groupStudentService.editStudentGroup(jsonRequest);
        return new ResponseEntity<>(editStudentGroupResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> DeleteStudentGroup(@Valid @RequestParam("id") @Positive int id) throws EntityNotFoundInDataBase {
        DeleteStudentGroupRequest deleteStudentGroupRequest = SpringConfig.getContext().getBean("deleteStudentGroupRequest", DeleteStudentGroupRequest.class);
        deleteStudentGroupRequest.setId(id);

        String dataResponse = groupStudentService.deleteStudentGroup(deleteStudentGroupRequest);
        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }
}
