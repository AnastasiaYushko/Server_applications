package org.example.network_operations.controllers;

import org.apache.http.HttpStatus;
import org.example.SpringConfig;
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

import javax.xml.rpc.ServiceException;
import java.util.ArrayList;
import java.util.List;

public class SubjectController {

    public static ResponseEntity<?> addSubject(AddSubjectRequest request) {
        AddSubjectValidator validator = new AddSubjectValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        SubjectServiceImpl subjectService = SpringConfig.getContext().getBean("subjectServiceImpl", SubjectServiceImpl.class);

        try {
            AddSubjectResponse addSubjectResponse = subjectService.addSubject(request);
            return new ResponseEntity<>(addSubjectResponse, HttpStatus.SC_OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }


    public static ResponseEntity<?> editSubject(EditSubjectRequest request) {
        EditSubjectValidator validator = new EditSubjectValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        SubjectServiceImpl subjectService = SpringConfig.getContext().getBean("subjectServiceImpl", SubjectServiceImpl.class);

        try {
            String editSubjectResponse = subjectService.editSubject(request);
            return new ResponseEntity<>(editSubjectResponse, HttpStatus.SC_OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ResponseEntity<?> getSubjectById(GetSubjectByIdRequest request) {
        GetSubjectByIdValidator validator = new GetSubjectByIdValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        SubjectServiceImpl subjectService = SpringConfig.getContext().getBean("subjectServiceImpl", SubjectServiceImpl.class);

        try {
            GetSubjectByIdResponse getSubjectsResponse = subjectService.getSubjectById(request);
            return new ResponseEntity<>(getSubjectsResponse, HttpStatus.SC_OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ResponseEntity<?> deleteSubject(DeleteSubjectRequest request) {
        DeleteSubjectValidator validator = new DeleteSubjectValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        SubjectServiceImpl subjectService = SpringConfig.getContext().getBean("subjectServiceImpl", SubjectServiceImpl.class);

        try {
            String dataResponse = subjectService.deleteSubject(request);
            return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ResponseEntity<GetSubjectsResponse> getSubjects() {

        SubjectServiceImpl subjectService = SpringConfig.getContext().getBean("subjectServiceImpl", SubjectServiceImpl.class);

        GetSubjectsResponse dataResponse = subjectService.getSubjects();
        return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
    }

}
