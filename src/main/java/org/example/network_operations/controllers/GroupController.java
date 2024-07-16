package org.example.network_operations.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.http.HttpStatus;
import org.example.app;
import org.example.dto_request.studentGroup.add.AddStudentGroupRequest;
import org.example.dto_request.studentGroup.add.AddStudentGroupValidator;
import org.example.dto_request.studentGroup.delete.DeleteStudentGroupRequest;
import org.example.dto_request.studentGroup.delete.DeleteStudentGroupValidator;
import org.example.dto_request.studentGroup.edit.EditStudentGroupRequest;
import org.example.dto_request.studentGroup.edit.EditStudentGroupValidator;
import org.example.dto_request.studentGroup.get.GetStudentGroupByIdRequest;
import org.example.dto_request.studentGroup.get.GetStudentGroupByIdValidator;
import org.example.dto_response.studentGroup.AddStudentGroupResponse;
import org.example.dto_response.studentGroup.GetStudentGroupByIdResponse;
import org.example.dto_response.studentGroup.GetStudentGroupsResponse;
import org.example.network_operations.ResponseEntity;
import org.example.services.serviceInterfaceImpl.GroupStudentServiceImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupController {

    public static ResponseEntity<GetStudentGroupByIdResponse> getStudentGroupById(GetStudentGroupByIdRequest request) throws JsonProcessingException {

        GetStudentGroupByIdValidator validator = new GetStudentGroupByIdValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }

        GroupStudentServiceImpl groupStudentService = app.getContext().getBean("group_student_service", GroupStudentServiceImpl.class);

        GetStudentGroupByIdResponse getStudentGroupByIdResponse;
        int status = HttpStatus.SC_OK;
        try {
            getStudentGroupByIdResponse = groupStudentService.getStudentGroupById(request);
        } catch (Exception e) {
            getStudentGroupByIdResponse = null;
            status = HttpStatus.SC_NOT_FOUND;
        }

        return new ResponseEntity<>(getStudentGroupByIdResponse, status);
    }

    public static ResponseEntity<String> editStudentGroup(EditStudentGroupRequest request) {
        EditStudentGroupValidator validator = new EditStudentGroupValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }

        GroupStudentServiceImpl groupStudentService = app.getContext().getBean("group_student_service", GroupStudentServiceImpl.class);

        String editStudentGroupResponse;
        int status = HttpStatus.SC_OK;
        try {
            editStudentGroupResponse = groupStudentService.editStudentGroup(request);
        } catch (Exception e) {
            editStudentGroupResponse = null;
            status = HttpStatus.SC_NOT_FOUND;
        }

        return new ResponseEntity<>(editStudentGroupResponse, status);
    }

    public static ResponseEntity<AddStudentGroupResponse> addStudentGroup(AddStudentGroupRequest request) {
        AddStudentGroupValidator validator = new AddStudentGroupValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }

        GroupStudentServiceImpl groupStudentService = app.getContext().getBean("group_student_service", GroupStudentServiceImpl.class);

        AddStudentGroupResponse addStudentGroupResponse;
        int status = HttpStatus.SC_OK;
        try {
            addStudentGroupResponse = groupStudentService.addStudentGroup(request);
        } catch (Exception e) {
            addStudentGroupResponse = null;
            status = HttpStatus.SC_NOT_FOUND;
        }

        return new ResponseEntity<>(addStudentGroupResponse, status);
    }

    public static ResponseEntity<String> deleteStudentGroup(DeleteStudentGroupRequest request) {
        DeleteStudentGroupValidator validator = new DeleteStudentGroupValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }


        GroupStudentServiceImpl groupStudentService = app.getContext().getBean("group_student_service", GroupStudentServiceImpl.class);

        String dataResponse;
        int status = HttpStatus.SC_OK;
        try {
            dataResponse = groupStudentService.deleteStudentGroup(request);
        } catch (Exception e) {
            dataResponse = null;
            status = HttpStatus.SC_NOT_FOUND;
        }

        return new ResponseEntity<>(dataResponse, status);
    }

    public static ResponseEntity<GetStudentGroupsResponse> getStudentGroups() {

        GroupStudentServiceImpl groupStudentService = app.getContext().getBean("group_student_service", GroupStudentServiceImpl.class);

        GetStudentGroupsResponse getStudentGroupsResponse;
        int status = HttpStatus.SC_OK;
        try {
            getStudentGroupsResponse = groupStudentService.getStudentGroups();
        } catch (Exception e) {
            getStudentGroupsResponse = null;
            status = HttpStatus.SC_NOT_FOUND;
        }

        return new ResponseEntity<>(getStudentGroupsResponse, status);
    }
}
