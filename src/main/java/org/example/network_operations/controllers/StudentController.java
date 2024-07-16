package org.example.network_operations.controllers;

import org.apache.http.HttpStatus;
import org.example.app;
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
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentController {

    public static ResponseEntity<GetStudentByIdResponse> getStudentById(GetStudentByIdRequest request) {

        GetStudentByIdValidator validator = new GetStudentByIdValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }

        StudentServiceImpl studentService = app.getContext().getBean("student_service", StudentServiceImpl.class);
        GetStudentByIdResponse studentResponse = studentService.getStudentById(request);

        return new ResponseEntity<>(studentResponse, HttpStatus.SC_ACCEPTED);
    }

    public static ResponseEntity<GetStudentsByGroupResponse> getStudentByGroup(GetStudentsByGroupRequest request) {

        GetStudentsByGroupValidator validator = new GetStudentsByGroupValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }

        StudentServiceImpl studentService = app.getContext().getBean("student_service", StudentServiceImpl.class);

        GetStudentsByGroupResponse getStudentsByGroupResponse = studentService.getStudentsByGroup(request);

        return new ResponseEntity<>(getStudentsByGroupResponse, HttpStatus.SC_OK);
    }

    public static ResponseEntity<String> editStudent(EditStudentRequest request) {
        EditStudentValidator validator = new EditStudentValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }

        StudentServiceImpl studentService = app.getContext().getBean("student_service", StudentServiceImpl.class);

        String editStudentResponse = studentService.editStudent(request);

        return new ResponseEntity<>(editStudentResponse, HttpStatus.SC_OK);
    }

    public static ResponseEntity<AddStudentResponse> addStudent(AddStudentRequest request) {

        AddStudentValidator validator = new AddStudentValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }

        StudentServiceImpl studentService = app.getContext().getBean("student_service", StudentServiceImpl.class);

        AddStudentResponse addStudentResponse = studentService.addStudent(request);

        return new ResponseEntity<>(addStudentResponse, HttpStatus.SC_OK);
    }

    public static ResponseEntity<String> deleteStudent(DeleteStudentRequest request) {

        DeleteStudentValidator validator = new DeleteStudentValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }

        StudentServiceImpl studentService = app.getContext().getBean("student_service", StudentServiceImpl.class);

        String data = studentService.deleteStudent(request);
        return new ResponseEntity<>(data, HttpStatus.SC_OK);
    }
}