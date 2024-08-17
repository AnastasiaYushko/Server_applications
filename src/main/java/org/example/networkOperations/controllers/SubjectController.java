/*
package org.example.networkOperations.controllers;

import org.apache.http.HttpStatus;
import org.example.SpringConfig;
import org.example.dtoRequest.subject.AddSubjectRequest;
import org.example.dtoRequest.subject.validation.AddSubjectValidator;
import org.example.dtoRequest.subject.DeleteSubjectRequest;
import org.example.dtoRequest.subject.validation.DeleteSubjectValidator;
import org.example.dtoRequest.subject.EditSubjectRequest;
import org.example.dtoRequest.subject.validation.EditSubjectValidator;
import org.example.dtoRequest.subject.GetSubjectByIdRequest;
import org.example.dtoRequest.subject.validation.GetSubjectByIdValidator;
import org.example.dtoResponse.subject.AddSubjectResponse;
import org.example.dtoResponse.subject.GetSubjectByIdResponse;
import org.example.dtoResponse.subject.GetSubjectsResponse;
import org.example.ResponseEntity;
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
 */
