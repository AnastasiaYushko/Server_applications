/*package org.example.networkOperations.controllers;

import org.apache.http.HttpStatus;
import org.example.SpringConfig;
import org.example.dtoRequest.student.AddStudentRequest;
import org.example.dtoRequest.student.validation.AddStudentValidator;
import org.example.dtoRequest.student.DeleteStudentRequest;
import org.example.dtoRequest.student.validation.DeleteStudentValidator;
import org.example.dtoRequest.student.EditStudentRequest;
import org.example.dtoRequest.student.validation.EditStudentValidator;
import org.example.dtoRequest.student.GetStudentsByGroupRequest;
import org.example.dtoRequest.student.validation.GetStudentsByGroupValidator;
import org.example.dtoRequest.student.GetStudentByIdRequest;
import org.example.dtoRequest.student.validation.GetStudentByIdValidator;
import org.example.dtoResponse.student.AddStudentResponse;
import org.example.dtoResponse.student.GetStudentByIdResponse;
import org.example.dtoResponse.student.GetStudentsByGroupResponse;
import org.example.ResponseEntity;
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
 */