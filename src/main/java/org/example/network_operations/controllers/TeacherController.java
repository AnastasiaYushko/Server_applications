package org.example.network_operations.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.http.HttpStatus;
import org.example.dto_request.teacher.add.AddTeacherRequest;
import org.example.dto_request.teacher.add.AddTeacherValidator;
import org.example.dto_request.teacher.delete.DeleteTeacherRequest;
import org.example.dto_request.teacher.delete.DeleteTeacherValidator;
import org.example.dto_request.teacher.edit.EditTeacherRequest;
import org.example.dto_request.teacher.edit.EditTeacherValidator;
import org.example.dto_request.teacher.get.GetTeacherByIdRequest;
import org.example.dto_request.teacher.get.GetTeacherByIdValidator;
import org.example.dto_response.teacher.AddTeacherResponse;
import org.example.dto_response.teacher.EditTeacherResponse;
import org.example.dto_response.teacher.GetTeacherByIdResponse;
import org.example.dto_response.teacher.GetTeachersResponse;
import org.example.network_operations.ResponseEntity;
import org.example.services.serviceInterfaceImpl.TeacherServiceImpl;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class TeacherController {
    public static ResponseEntity<String> deleteTeacher(@RequestBody DeleteTeacherRequest request) throws JsonProcessingException {
        DeleteTeacherValidator validator = new DeleteTeacherValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request,errors);

        if (!errors.isEmpty()) {
            for (String error : errors) {
                System.out.println(error);
            }
            return null;
        }

        TeacherServiceImpl teacherService = new TeacherServiceImpl();

        String dataResponse = teacherService.deleteTeacher(request);

        return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
    }

    public static ResponseEntity<AddTeacherResponse> addTeacher(@RequestBody AddTeacherRequest request) throws JsonProcessingException{
        AddTeacherValidator validator = new AddTeacherValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request,errors);

        if (!errors.isEmpty()) {
            for (String error : errors) {
                System.out.println(error);
            }
            return null;
        }

        TeacherServiceImpl teacherService = new TeacherServiceImpl();

        AddTeacherResponse dataResponse = teacherService.addTeacher(request);

        return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
    }

    public static ResponseEntity<EditTeacherResponse> editTeacher(@RequestBody EditTeacherRequest request) throws JsonProcessingException{
        EditTeacherValidator validator = new EditTeacherValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request,errors);

        if (!errors.isEmpty()) {
            for (String error : errors) {
                System.out.println(error);
            }
            return null;
        }

        TeacherServiceImpl teacherService = new TeacherServiceImpl();

        EditTeacherResponse dataResponse = teacherService.editTeacher(request);

        return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
    }

    public static ResponseEntity<GetTeacherByIdResponse> getTeacherById(@RequestBody GetTeacherByIdRequest request) throws JsonProcessingException{
        GetTeacherByIdValidator validator = new GetTeacherByIdValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request,errors);

        if (!errors.isEmpty()) {
            for (String error : errors) {
                System.out.println(error);
            }
            return null;
        }

        TeacherServiceImpl teacherService = new TeacherServiceImpl();

        GetTeacherByIdResponse dataResponse = teacherService.getTeacherById(request);

        return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
    }

    public static ResponseEntity<GetTeachersResponse> getTeachers() throws JsonProcessingException{

        TeacherServiceImpl teacherService = new TeacherServiceImpl();

        GetTeachersResponse dataResponse = teacherService.getTeachers();

        return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
    }
}
