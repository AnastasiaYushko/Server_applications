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
import org.example.network_operations.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class GroupController {

    public ResponseEntity<GetStudentGroupByIdResponse> getStudentGroupById(@RequestBody GetStudentGroupByIdRequest request) throws JsonProcessingException {

        GetStudentGroupByIdValidator validator = new GetStudentGroupByIdValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request,errors);

        //Обработка ошибок валидации
        if (!errors.isEmpty()) {
            for (String error : errors) {
                System.out.println(error);
            }
            return null;
        }

        //Заглушка

        return new ResponseEntity<>(null, HttpStatus.SC_OK);
    }

    public ResponseEntity<EditStudentGroupResponse> editStudentGroup(@RequestBody EditStudentGroupRequest request) throws JsonProcessingException {
        EditStudentGroupValidator validator = new EditStudentGroupValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request,errors);

        //Обработка ошибок валидации
        if (!errors.isEmpty()) {
            for (String error : errors) {
                System.out.println(error);
            }
            return null;
        }

        //Заглушка

        return new ResponseEntity<>(null, HttpStatus.SC_OK);
    }

    public ResponseEntity<AddStudentGroupResponse> addStudentGroup(@RequestBody AddStudentGroupRequest request) throws JsonProcessingException {
        AddStudentGroupValidator validator = new AddStudentGroupValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request,errors);

        //Обработка ошибок валидации
        if (!errors.isEmpty()) {
            for (String error : errors) {
                System.out.println(error);
            }
            return null;
        }

        //Заглушка

        return new ResponseEntity<>(null, HttpStatus.SC_OK);
    }

    public ResponseEntity<Void> deleteStudentGroup(@RequestBody DeleteStudentGroupRequest request) throws JsonProcessingException {
        DeleteStudentGroupValidator validator = new DeleteStudentGroupValidator();
        List<String> errors = new ArrayList<>();
        validator.validate(request,errors);

        //Обработка ошибок валидации
        if (!errors.isEmpty()) {
            for (String error : errors) {
                System.out.println(error);
            }
            return null;
        }

        //Заглушка

        return new ResponseEntity<>(null, HttpStatus.SC_OK);
    }

}
