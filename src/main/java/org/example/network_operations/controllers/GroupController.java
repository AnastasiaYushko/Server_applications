package org.example.network_operations.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.http.HttpStatus;
import org.example.dto_request.studentGroup.add.AddStudentGroupRequest;
import org.example.dto_request.studentGroup.add.AddStudentGroupValidator;
import org.example.dto_request.studentGroup.delete.DeleteStudentGroupRequest;
import org.example.dto_request.studentGroup.delete.DeleteStudentGroupValidator;
import org.example.dto_request.studentGroup.edit.EditStudentGroupRequest;
import org.example.dto_request.studentGroup.edit.EditStudentGroupValidator;
import org.example.dto_request.studentGroup.get.GetStudentGroupByIdRequest;
import org.example.dto_request.studentGroup.get.GetStudentGroupByIdValidator;
import org.example.dto_response.studentGroup.AddStudentGroupResponse;
import org.example.dto_response.studentGroup.EditStudentGroupResponse;
import org.example.dto_response.studentGroup.GetStudentGroupByIdResponse;
import org.example.dto_response.studentGroup.GetStudentGroupsResponse;
import org.example.network_operations.ResponseEntity;
import org.example.services.serviceInterfaceImpl.GroupStudentServiceImpl;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class GroupController {

    public static ResponseEntity<GetStudentGroupByIdResponse> getStudentGroupById(@RequestBody GetStudentGroupByIdRequest request) throws JsonProcessingException {

        GetStudentGroupByIdValidator validator = new GetStudentGroupByIdValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request,errors);

        if (!errors.isEmpty()) {
            for (String error : errors) {
                System.out.println(error);
            }
            return null;
        }

        GroupStudentServiceImpl groupStudentService = new GroupStudentServiceImpl();

        GetStudentGroupByIdResponse getStudentGroupByIdResponse = groupStudentService.getStudentGroupById(request);

        return new ResponseEntity<>(getStudentGroupByIdResponse, HttpStatus.SC_OK);
    }

    public static ResponseEntity<EditStudentGroupResponse> editStudentGroup(@RequestBody EditStudentGroupRequest request) throws JsonProcessingException {
        EditStudentGroupValidator validator = new EditStudentGroupValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request,errors);

        if (!errors.isEmpty()) {
            for (String error : errors) {
                System.out.println(error);
            }
            return null;
        }

        GroupStudentServiceImpl groupStudentService = new GroupStudentServiceImpl();

        EditStudentGroupResponse editStudentGroupResponse = groupStudentService.editStudentGroup(request);

        return new ResponseEntity<>(editStudentGroupResponse, HttpStatus.SC_OK);
    }

    public static ResponseEntity<AddStudentGroupResponse> addStudentGroup(@RequestBody AddStudentGroupRequest request) throws JsonProcessingException {
        AddStudentGroupValidator validator = new AddStudentGroupValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request,errors);

        if (!errors.isEmpty()) {
            for (String error : errors) {
                System.out.println(error);
            }
            return null;
        }

        GroupStudentServiceImpl groupStudentService = new GroupStudentServiceImpl();

        AddStudentGroupResponse addStudentGroupResponse = groupStudentService.addStudentGroup(request);

        return new ResponseEntity<>(addStudentGroupResponse, HttpStatus.SC_OK);
    }

    public static ResponseEntity<String> deleteStudentGroup(@RequestBody DeleteStudentGroupRequest request) throws JsonProcessingException {
        DeleteStudentGroupValidator validator = new DeleteStudentGroupValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request,errors);

        if (!errors.isEmpty()) {
            for (String error : errors) {
                System.out.println(error);
            }
            return null;
        }

        GroupStudentServiceImpl groupStudentService = new GroupStudentServiceImpl();
        String dataResponse = groupStudentService.deleteStudentGroup(request);

        return new ResponseEntity<>(dataResponse, HttpStatus.SC_OK);
    }

    public static ResponseEntity<GetStudentGroupsResponse> getStudentGroups() throws JsonProcessingException{
        GroupStudentServiceImpl groupStudentService = new GroupStudentServiceImpl();
        GetStudentGroupsResponse getStudentGroupsResponse = groupStudentService.getStudentGroups();
        return new ResponseEntity<>(getStudentGroupsResponse, HttpStatus.SC_OK);
    }
}
