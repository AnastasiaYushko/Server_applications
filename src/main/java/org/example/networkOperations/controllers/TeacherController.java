/*package org.example.networkOperations.controllers;

import org.apache.http.HttpStatus;
import org.example.SpringConfig;
import org.example.dtoRequest.teacher.AddTeacherRequest;
import org.example.dtoRequest.teacher.DeleteTeacherRequest;
import org.example.dtoRequest.teacher.EditTeacherRequest;
import org.example.dtoRequest.teacher.validation.EditTeacherValidator;
import org.example.dtoRequest.teacher.GetTeacherByIdRequest;
import org.example.dtoRequest.teacher.validation.GetTeacherByIdValidator;
import org.example.dtoResponse.teacher.AddTeacherResponse;
import org.example.dtoResponse.teacher.GetTeacherByIdResponse;
import org.example.dtoResponse.teacher.GetTeachersResponse;
import org.example.ResponseEntity;
import org.example.services.serviceInterfaceImpl.TeacherServiceImpl;

import javax.xml.rpc.ServiceException;
import java.util.ArrayList;
import java.util.List;

public class TeacherController {

    public static ResponseEntity<?> deleteTeacher(DeleteTeacherRequest request) {
        //DeleteTeacherValidator validator = new DeleteTeacherValidator();
        //List<String> errors = new ArrayList<>();
        //validator.validate(request, errors);

        //if (!errors.isEmpty()) {
        //    return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        //}

        TeacherServiceImpl teacherService = SpringConfig.getContext().getBean("teacherServiceImpl", TeacherServiceImpl.class);

        try {
            String dataResponse = teacherService.deleteTeacher(request);
            return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ResponseEntity<?> addTeacher(AddTeacherRequest request) {

        TeacherServiceImpl teacherService = SpringConfig.getContext().getBean("teacherServiceImpl", TeacherServiceImpl.class);

        try {
            AddTeacherResponse dataResponse = teacherService.addTeacher(request);
            return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ResponseEntity<?> editTeacher(EditTeacherRequest request) {
        EditTeacherValidator validator = new EditTeacherValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        TeacherServiceImpl teacherService = SpringConfig.getContext().getBean("teacherServiceImpl", TeacherServiceImpl.class);

        try {
            String dataResponse = teacherService.editTeacher(request);
            return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ResponseEntity<?> getTeacherById(GetTeacherByIdRequest request) {
        GetTeacherByIdValidator validator = new GetTeacherByIdValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        TeacherServiceImpl teacherService = SpringConfig.getContext().getBean("teacherServiceImpl", TeacherServiceImpl.class);

        try {
            GetTeacherByIdResponse dataResponse = teacherService.getTeacherById(request);
            return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ResponseEntity<GetTeachersResponse> getTeachers() {

        TeacherServiceImpl teacherService = SpringConfig.getContext().getBean("teacherServiceImpl", TeacherServiceImpl.class);

        GetTeachersResponse dataResponse = teacherService.getTeachers();
        return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
    }
}
 */