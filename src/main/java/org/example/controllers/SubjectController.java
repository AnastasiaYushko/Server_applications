package org.example.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

import org.example.ResponseEntity;
import org.example.SpringConfig;
import org.example.dto.dtoRequest.subject.AddSubjectRequest;
import org.example.dto.dtoRequest.subject.DeleteSubjectRequest;
import org.example.dto.dtoRequest.subject.EditSubjectRequest;
import org.example.dto.dtoRequest.subject.GetSubjectByIdRequest;
import org.example.dto.dtoResponse.subject.AddSubjectResponse;
import org.example.dto.dtoResponse.subject.GetSubjectByIdResponse;
import org.example.dto.dtoResponse.subject.GetSubjectsResponse;
import org.example.services.serviceInterfaceImpl.SubjectServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.xml.rpc.ServiceException;

@RestController
@RequestMapping(value = "/subject", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class SubjectController {

    private final SubjectServiceImpl subjectService;

    @Autowired
    public SubjectController(SubjectServiceImpl subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/get")
    public ResponseEntity<GetSubjectsResponse> GetSubjects() {
        GetSubjectsResponse dataResponse = subjectService.getSubjects();
        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<?> GetSubjectById(@Valid @RequestParam("id") @Positive int id) {
        GetSubjectByIdRequest getSubjectByIdRequest = SpringConfig.getContext().getBean("getSubjectByIdRequest", GetSubjectByIdRequest.class);
        getSubjectByIdRequest.setId(id);
        try {
            GetSubjectByIdResponse getSubjectsResponse = subjectService.getSubjectById(getSubjectByIdRequest);
            return new ResponseEntity<>(getSubjectsResponse, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> AddSubject(@Valid @RequestBody AddSubjectRequest jsonRequest) {
        try {
            AddSubjectResponse addSubjectResponse = subjectService.addSubject(jsonRequest);
            return new ResponseEntity<>(addSubjectResponse, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/edit")
    public ResponseEntity<?> EditSubject(@Valid @RequestBody EditSubjectRequest jsonRequest) {
        try {
            String editSubjectResponse = subjectService.editSubject(jsonRequest);
            return new ResponseEntity<>(editSubjectResponse, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> DeleteSubject(@Valid @RequestParam("id") @Positive int id) {
        DeleteSubjectRequest deleteSubjectRequest = SpringConfig.getContext().getBean("deleteSubjectRequest", DeleteSubjectRequest.class);
        deleteSubjectRequest.setId(id);
        try {
            String dataResponse = subjectService.deleteSubject(deleteSubjectRequest);
            return new ResponseEntity<>(dataResponse, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}