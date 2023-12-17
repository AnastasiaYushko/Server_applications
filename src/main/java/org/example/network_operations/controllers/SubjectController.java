package org.example.network_operations.controllers;

import org.apache.http.HttpStatus;
import org.example.dto_request.subject.add.AddSubjectRequest;
import org.example.dto_request.subject.add.AddSubjectValidator;
import org.example.dto_request.subject.delete.DeleteSubjectRequest;
import org.example.dto_request.subject.delete.DeleteSubjectValidator;
import org.example.dto_request.subject.edit.EditSubjectRequest;
import org.example.dto_request.subject.edit.EditSubjectValidator;
import org.example.dto_request.subject.get.GetSubjectByIdRequest;
import org.example.dto_request.subject.get.GetSubjectByIdValidator;
import org.example.dto_response.subject.AddSubjectResponse;
import org.example.dto_response.subject.GetSubjectByIdResponse;
import org.example.dto_response.subject.GetSubjectsResponse;
import org.example.network_operations.ResponseEntity;
import org.example.services.serviceInterfaceImpl.SubjectServiceImpl;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class SubjectController {

    public static ResponseEntity<AddSubjectResponse> addSubject(@RequestBody AddSubjectRequest request) {
        AddSubjectValidator validator = new AddSubjectValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request,errors);

        if (!errors.isEmpty()) {
            for (String error : errors) {
                System.out.println(error);
            }
            return null;
        }

        SubjectServiceImpl subjectService = new SubjectServiceImpl();

        AddSubjectResponse addSubjectResponse = subjectService.addSubject(request);

        return new ResponseEntity<>(addSubjectResponse, HttpStatus.SC_OK);
    }

    public static ResponseEntity<String> editSubject(@RequestBody EditSubjectRequest request) {
        EditSubjectValidator validator = new EditSubjectValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request,errors);

        if (!errors.isEmpty()) {
            for (String error : errors) {
                System.out.println(error);
            }
            return null;
        }

        SubjectServiceImpl subjectService = new SubjectServiceImpl();

        String editSubjectResponse = subjectService.editSubject(request);
        return new ResponseEntity<>(editSubjectResponse, HttpStatus.SC_CREATED);
    }

    public static ResponseEntity<GetSubjectByIdResponse> getSubjectById(@RequestBody GetSubjectByIdRequest request) {
        GetSubjectByIdValidator validator = new GetSubjectByIdValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request,errors);

        if (!errors.isEmpty()) {
            for (String error : errors) {
                System.out.println(error);
            }
            return null;
        }

        SubjectServiceImpl subjectService = new SubjectServiceImpl();

        GetSubjectByIdResponse getSubjectsResponse = subjectService.getSubjectById(request);
        return new ResponseEntity<>(getSubjectsResponse, HttpStatus.SC_OK);
    }

    public static ResponseEntity<String> deleteSubject(@RequestBody DeleteSubjectRequest request) {
        DeleteSubjectValidator validator = new DeleteSubjectValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request,errors);

        if (!errors.isEmpty()) {
            for (String error : errors) {
                System.out.println(error);
            }
            return null;
        }

        SubjectServiceImpl subjectService = new SubjectServiceImpl();

        String dataResponse = subjectService.deleteSubject(request);
        return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
    }

    public static ResponseEntity<GetSubjectsResponse> getSubjects () {

        SubjectServiceImpl subjectService = new SubjectServiceImpl();

        GetSubjectsResponse dataResponse = subjectService.getSubjects();
        return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
    }
}
