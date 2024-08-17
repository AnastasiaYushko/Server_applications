/*
package org.example.networkOperations.controllers;

import org.apache.http.HttpStatus;
import org.example.SpringConfig;
import org.example.dtoRequest.studentGroup.AddStudentGroupRequest;
import org.example.dtoRequest.studentGroup.DeleteStudentGroupRequest;
import org.example.dtoRequest.studentGroup.EditStudentGroupRequest;
import org.example.dtoRequest.studentGroup.GetStudentGroupByIdRequest;
import org.example.dtoRequest.studentGroup.validation.AddStudentGroupValidator;
import org.example.dtoRequest.studentGroup.validation.DeleteStudentGroupValidator;
import org.example.dtoRequest.studentGroup.validation.EditStudentGroupValidator;
import org.example.dtoRequest.studentGroup.validation.GetStudentGroupByIdValidator;
import org.example.dtoResponse.studentGroup.AddStudentGroupResponse;
import org.example.dtoResponse.studentGroup.GetStudentGroupByIdResponse;
import org.example.dtoResponse.studentGroup.GetStudentGroupsResponse;
import org.example.ResponseEntity;
import org.example.services.serviceInterfaceImpl.GroupStudentServiceImpl;

import javax.xml.rpc.ServiceException;
import java.util.ArrayList;
import java.util.List;

public class GroupController {

    public static ResponseEntity<?> getStudentGroupById(GetStudentGroupByIdRequest request)  {

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
 */