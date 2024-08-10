package org.example.network_operations.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.http.HttpStatus;
import org.example.SpringConfig;
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

import javax.xml.rpc.ServiceException;
import java.util.ArrayList;
import java.util.List;

public class GroupController {

    public static ResponseEntity<?> getStudentGroupById(GetStudentGroupByIdRequest request) throws JsonProcessingException {

        GetStudentGroupByIdValidator validator = new GetStudentGroupByIdValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        GroupStudentServiceImpl groupStudentService = SpringConfig.getContext().getBean("groupStudentServiceImpl", GroupStudentServiceImpl.class);

        try {
            GetStudentGroupByIdResponse getStudentGroupByIdResponse = groupStudentService.getStudentGroupById(request);
            return new ResponseEntity<>(getStudentGroupByIdResponse, HttpStatus.SC_OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ResponseEntity<?> editStudentGroup(EditStudentGroupRequest request) {


        EditStudentGroupValidator validator = new EditStudentGroupValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }
        GroupStudentServiceImpl groupStudentService = SpringConfig.getContext().getBean("groupStudentServiceImpl", GroupStudentServiceImpl.class);

        try {
            String editStudentGroupResponse = groupStudentService.editStudentGroup(request);
            return new ResponseEntity<>(editStudentGroupResponse, HttpStatus.SC_OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ResponseEntity<?> addStudentGroup(AddStudentGroupRequest request) {
        AddStudentGroupValidator validator = new AddStudentGroupValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        GroupStudentServiceImpl groupStudentService = SpringConfig.getContext().getBean("groupStudentServiceImpl", GroupStudentServiceImpl.class);
        try {
            AddStudentGroupResponse addStudentGroupResponse = groupStudentService.addStudentGroup(request);
            return new ResponseEntity<>(addStudentGroupResponse, HttpStatus.SC_OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ResponseEntity<?> deleteStudentGroup(DeleteStudentGroupRequest request) {
        DeleteStudentGroupValidator validator = new DeleteStudentGroupValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request, errors);

        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.SC_BAD_REQUEST);
        }

        GroupStudentServiceImpl groupStudentService = SpringConfig.getContext().getBean("groupStudentServiceImpl", GroupStudentServiceImpl.class);
        try {
            String dataResponse = groupStudentService.deleteStudentGroup(request);
            return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SC_NOT_FOUND);
        }
    }

    public static ResponseEntity<GetStudentGroupsResponse> getStudentGroups() {

        GroupStudentServiceImpl groupStudentService = SpringConfig.getContext().getBean("groupStudentServiceImpl", GroupStudentServiceImpl.class);

        GetStudentGroupsResponse getStudentGroupsResponse = groupStudentService.getStudentGroups();
        return new ResponseEntity<>(getStudentGroupsResponse, HttpStatus.SC_OK);
    }
}