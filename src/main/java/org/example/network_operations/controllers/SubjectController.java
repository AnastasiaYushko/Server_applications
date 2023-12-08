package org.example.network_operations.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.http.HttpStatus;
import org.example.dto_request.subject.add.AddSubjectRequest;
import org.example.dto_request.subject.edit.EditSubjectRequest;
import org.example.dto_request.subject.get.GetSubjectByIdRequest;
import org.example.dto_response.subject.AddSubjectResponse;
import org.example.dto_response.subject.EditSubjectResponse;
import org.example.dto_response.subject.GetSubjectByIdResponse;
import org.example.network_operations.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public class SubjectController {

    public static ResponseEntity<AddSubjectResponse> addStudent(@RequestBody AddSubjectRequest request) throws JsonProcessingException {
        // Заглушка, пока сервис не реализован
        return new ResponseEntity<>(null, HttpStatus.SC_CREATED);
    }

    public static ResponseEntity<EditSubjectResponse> editStudent(@RequestBody EditSubjectRequest request) throws JsonProcessingException {
        // Заглушка, пока сервис не реализован
        return new ResponseEntity<>(null, HttpStatus.SC_CREATED);
    }

    public static ResponseEntity<GetSubjectByIdResponse> getSubjectById(@RequestBody GetSubjectByIdRequest request) throws JsonProcessingException {
        // Заглушка, пока сервис не реализован
        return new ResponseEntity<>(null, HttpStatus.SC_CREATED);
    }

}
