package org.example.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.example.SpringConfig;
import org.example.dto.dtoRequest.subject.AddSubjectRequest;
import org.example.dto.dtoRequest.subject.DeleteSubjectRequest;
import org.example.dto.dtoRequest.subject.EditSubjectRequest;
import org.example.dto.dtoRequest.subject.GetSubjectByIdRequest;
import org.example.dto.dtoResponse.subject.AddSubjectResponse;
import org.example.dto.dtoResponse.subject.GetSubjectByIdResponse;
import org.example.dto.dtoResponse.subject.GetSubjectsResponse;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;
import org.example.services.serviceInterfaceImpl.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/subject")
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
    public ResponseEntity<GetSubjectByIdResponse> GetSubjectById(@Valid @RequestParam("id") @Positive int id) throws EntityNotFoundInDataBase {
        GetSubjectByIdRequest getSubjectByIdRequest = SpringConfig.getContext().getBean("getSubjectByIdRequest", GetSubjectByIdRequest.class);
        getSubjectByIdRequest.setId(id);

        GetSubjectByIdResponse getSubjectsResponse = subjectService.getSubjectById(getSubjectByIdRequest);
        return new ResponseEntity<>(getSubjectsResponse, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<AddSubjectResponse> AddSubject(@Valid @RequestBody AddSubjectRequest jsonRequest) throws AddEntityMatchData {
        AddSubjectResponse addSubjectResponse = subjectService.addSubject(jsonRequest);
        return new ResponseEntity<>(addSubjectResponse, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<String> EditSubject(@Valid @RequestBody EditSubjectRequest jsonRequest) throws StupidChanges, ChangesEntityLeadToConflict, EntityNotFoundInDataBase {
        String editSubjectResponse = subjectService.editSubject(jsonRequest);
        return new ResponseEntity<>(editSubjectResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> DeleteSubject(@Valid @RequestParam("id") @Positive int id) throws EntityNotFoundInDataBase {
        DeleteSubjectRequest deleteSubjectRequest = SpringConfig.getContext().getBean("deleteSubjectRequest", DeleteSubjectRequest.class);
        deleteSubjectRequest.setId(id);

        String dataResponse = subjectService.deleteSubject(deleteSubjectRequest);
        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }
}
