package org.example.network_operations.controllers;

import org.apache.http.HttpStatus;
import org.example.SpringConfig;
import org.example.dto_request.student.AddStudentRequest;
import org.example.dto_request.student.validation.AddStudentValidator;
import org.example.dto_request.student.DeleteStudentRequest;
import org.example.dto_request.student.validation.DeleteStudentValidator;
import org.example.dto_request.student.EditStudentRequest;
import org.example.dto_request.student.validation.EditStudentValidator;
import org.example.dto_request.student.GetStudentsByGroupRequest;
import org.example.dto_request.student.validation.GetStudentsByGroupValidator;
import org.example.dto_request.student.GetStudentByIdRequest;
import org.example.dto_request.student.validation.GetStudentByIdValidator;
import org.example.dto_response.student.AddStudentResponse;
import org.example.dto_response.student.GetStudentByIdResponse;
import org.example.dto_response.student.GetStudentsByGroupResponse;
import org.example.network_operations.ResponseEntity;
import org.example.services.serviceInterfaceImpl.StudentServiceImpl;

import javax.xml.rpc.ServiceException;
import java.util.ArrayList;
import java.util.List;

public class StudentController {

    public static ResponseEntity<?> getStudentById(GetStudentByIdRequest request) {

        GetStudentByIdValidator validator = new GetStudentByIdValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        StudentServiceImpl studentService = SpringConfig.getContext().getBean("studentServiceImpl", StudentServiceImpl.class);
        try {
            GetStudentByIdResponse studentResponse = studentService.getStudentById(request);
            return new ResponseEntity<>(studentResponse, HttpStatus.SC_OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ResponseEntity<?> getStudentByGroup(GetStudentsByGroupRequest request) {

        GetStudentsByGroupValidator validator = new GetStudentsByGroupValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        StudentServiceImpl studentService = SpringConfig.getContext().getBean("studentServiceImpl", StudentServiceImpl.class);

        try {
            GetStudentsByGroupResponse getStudentsByGroupResponse = studentService.getStudentsByGroup(request);
            return new ResponseEntity<>(getStudentsByGroupResponse, HttpStatus.SC_OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ResponseEntity<?> editStudent(EditStudentRequest request) {
        EditStudentValidator validator = new EditStudentValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        StudentServiceImpl studentService = SpringConfig.getContext().getBean("studentServiceImpl", StudentServiceImpl.class);

        try {
            String editStudentResponse = studentService.editStudent(request);
            return new ResponseEntity<>(editStudentResponse, HttpStatus.SC_OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ResponseEntity<?> addStudent(AddStudentRequest request) {

        AddStudentValidator validator = new AddStudentValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        StudentServiceImpl studentService = SpringConfig.getContext().getBean("studentServiceImpl", StudentServiceImpl.class);

        try {
            AddStudentResponse addStudentResponse = studentService.addStudent(request);
            return new ResponseEntity<>(addStudentResponse, HttpStatus.SC_OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ResponseEntity<?> deleteStudent(DeleteStudentRequest request) {

        DeleteStudentValidator validator = new DeleteStudentValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        StudentServiceImpl studentService = SpringConfig.getContext().getBean("studentServiceImpl", StudentServiceImpl.class);

        try {
            String data = studentService.deleteStudent(request);
            return new ResponseEntity<>(data, HttpStatus.SC_OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }
}