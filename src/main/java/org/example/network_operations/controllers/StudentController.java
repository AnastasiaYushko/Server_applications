package org.example.network_operations.controllers;

import org.apache.http.HttpStatus;
import org.example.dto_request.student.add.AddStudentRequest;
import org.example.dto_request.student.add.AddStudentValidator;
import org.example.dto_request.student.delete.DeleteStudentRequest;
import org.example.dto_request.student.delete.DeleteStudentValidator;
import org.example.dto_request.student.edit.EditStudentRequest;
import org.example.dto_request.student.edit.EditStudentValidator;
import org.example.dto_request.student.get.byGroup.GetStudentsByGroupRequest;
import org.example.dto_request.student.get.byGroup.GetStudentsByGroupValidator;
import org.example.dto_request.student.get.byId.GetStudentByIdRequest;
import org.example.dto_request.student.get.byId.GetStudentByIdValidator;
import org.example.dto_response.student.AddStudentResponse;
import org.example.dto_response.student.GetStudentByIdResponse;
import org.example.dto_response.student.GetStudentsByGroupResponse;
import org.example.network_operations.ResponseEntity;
import org.example.services.serviceInterfaceImpl.StudentServiceImpl;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class StudentController {

    public static ResponseEntity<GetStudentByIdResponse> getStudentById(@RequestBody GetStudentByIdRequest request) {

        GetStudentByIdValidator validator = new GetStudentByIdValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }

        StudentServiceImpl studentService = new StudentServiceImpl();
        GetStudentByIdResponse studentResponse = studentService.getStudentById(request);

        return new ResponseEntity<>(studentResponse, HttpStatus.SC_ACCEPTED);
    }

    public static ResponseEntity<GetStudentsByGroupResponse> getStudentByGroup(@RequestBody GetStudentsByGroupRequest request) {

        GetStudentsByGroupValidator validator = new GetStudentsByGroupValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }

        StudentServiceImpl studentService = new StudentServiceImpl();

        GetStudentsByGroupResponse getStudentsByGroupResponse = studentService.getStudentsByGroup(request);

        return new ResponseEntity<>(getStudentsByGroupResponse, HttpStatus.SC_OK);
    }

    public static ResponseEntity<String> editStudent(@RequestBody EditStudentRequest request) {
        EditStudentValidator validator = new EditStudentValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }

        StudentServiceImpl studentService = new StudentServiceImpl();

        String editStudentResponse = studentService.editStudent(request);

        return new ResponseEntity<>(editStudentResponse, HttpStatus.SC_OK);
    }

    public static ResponseEntity<AddStudentResponse> addStudent(@RequestBody AddStudentRequest request) {

        AddStudentValidator validator = new AddStudentValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }

        StudentServiceImpl studentService = new StudentServiceImpl();

        AddStudentResponse addStudentResponse = studentService.addStudent(request);

        return new ResponseEntity<>(addStudentResponse, HttpStatus.SC_OK);
    }

    public static ResponseEntity<String> deleteStudent(@RequestBody DeleteStudentRequest request){

        DeleteStudentValidator validator = new DeleteStudentValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }

        StudentServiceImpl studentService = new StudentServiceImpl();

        String data = studentService.deleteStudent(request);
        return new ResponseEntity<>(data, HttpStatus.SC_OK);
    }
}