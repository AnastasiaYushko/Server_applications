package org.example.network_operations.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.http.HttpStatus;
import org.example.dto_request.teacher.add.AddTeacherRequest;
import org.example.dto_request.teacher.delete.DeleteTeacherRequest;
import org.example.dto_request.teacher.edit.EditTeacherRequest;
import org.example.dto_request.teacher.get.GetTeacherByIdRequest;
import org.example.dto_response.teacher.AddTeacherResponse;
import org.example.dto_response.teacher.EditTeacherResponse;
import org.example.dto_response.teacher.GetTeacherByIdResponse;
import org.example.dto_response.teacher.GetTeachersResponse;
import org.example.network_operations.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public class TeacherController {
    public static ResponseEntity<Void> deleteTeacher(@RequestBody DeleteTeacherRequest request) throws JsonProcessingException {
        // Заглушка, пока сервис не реализован
        return new ResponseEntity<>(null, HttpStatus.SC_ACCEPTED);
    }

    public static ResponseEntity<AddTeacherResponse> addTeacher(@RequestBody AddTeacherRequest request) throws JsonProcessingException{
        // Заглушка, пока сервис не реализован
        return new ResponseEntity<>(null, HttpStatus.SC_ACCEPTED);
    }

    public static ResponseEntity<EditTeacherResponse> editTeacher(@RequestBody EditTeacherRequest request) throws JsonProcessingException{
        // Заглушка, пока сервис не реализован
        return new ResponseEntity<>(null, HttpStatus.SC_ACCEPTED);
    }

    public static ResponseEntity<GetTeacherByIdResponse> getTeacherById(@RequestBody GetTeacherByIdRequest request) throws JsonProcessingException{
        // Заглушка, пока сервис не реализован
        return new ResponseEntity<>(null, HttpStatus.SC_ACCEPTED);
    }

    public static ResponseEntity<GetTeachersResponse> editStudent() throws JsonProcessingException{
        // Заглушка, пока сервис не реализован
        return new ResponseEntity<>(null, HttpStatus.SC_ACCEPTED);
    }
}
