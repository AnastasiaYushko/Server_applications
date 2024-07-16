package org.example.network_operations.controllers;

import org.apache.http.HttpStatus;
import org.example.app;
import org.example.dto_request.teacher.add.AddTeacherRequest;
import org.example.dto_request.teacher.add.AddTeacherValidator;
import org.example.dto_request.teacher.delete.DeleteTeacherRequest;
import org.example.dto_request.teacher.delete.DeleteTeacherValidator;
import org.example.dto_request.teacher.edit.EditTeacherRequest;
import org.example.dto_request.teacher.edit.EditTeacherValidator;
import org.example.dto_request.teacher.get.GetTeacherByIdRequest;
import org.example.dto_request.teacher.get.GetTeacherByIdValidator;
import org.example.dto_response.teacher.AddTeacherResponse;
import org.example.dto_response.teacher.GetTeacherByIdResponse;
import org.example.dto_response.teacher.GetTeachersResponse;
import org.example.network_operations.ResponseEntity;
import org.example.services.serviceInterfaceImpl.TeacherServiceImpl;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TeacherController {

    static ApplicationContext context = app.getContext();

    public static ResponseEntity<?> deleteTeacher(DeleteTeacherRequest request) {
        DeleteTeacherValidator validator = new DeleteTeacherValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        TeacherServiceImpl teacherService = app.getContext().getBean("teacher_service", TeacherServiceImpl.class);

        try {
            String dataResponse = teacherService.deleteTeacher(request);
            return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ResponseEntity<?> addTeacher(AddTeacherRequest request) {
        AddTeacherValidator validator = new AddTeacherValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        TeacherServiceImpl teacherService = app.getContext().getBean("teacher_service", TeacherServiceImpl.class);

        AddTeacherResponse dataResponse = teacherService.addTeacher(request);

        return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
    }

    public static ResponseEntity<String> editTeacher(EditTeacherRequest request) {
        EditTeacherValidator validator = new EditTeacherValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }

        TeacherServiceImpl teacherService = app.getContext().getBean("teacher_service", TeacherServiceImpl.class);

        String dataResponse = teacherService.editTeacher(request);

        return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
    }

    public static ResponseEntity<?> getTeacherById(GetTeacherByIdRequest request) {
        GetTeacherByIdValidator validator = new GetTeacherByIdValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        TeacherServiceImpl teacherService = context.getBean("teacher_service", TeacherServiceImpl.class);

        GetTeacherByIdResponse dataResponse;
        try {
            dataResponse = teacherService.getTeacherById(request);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }

        return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
    }

    public static ResponseEntity<GetTeachersResponse> getTeachers() {

        TeacherServiceImpl teacherService = app.getContext().getBean("teacher_service", TeacherServiceImpl.class);

        GetTeachersResponse dataResponse = teacherService.getTeachers();

        return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
    }
}
