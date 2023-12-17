package org.example.services.serviceInterface;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto_request.teacher.add.AddTeacherRequest;
import org.example.dto_request.teacher.delete.DeleteTeacherRequest;
import org.example.dto_request.teacher.edit.EditTeacherRequest;
import org.example.dto_request.teacher.get.GetTeacherByIdRequest;
import org.example.dto_response.teacher.AddTeacherResponse;
import org.example.dto_response.teacher.GetTeacherByIdResponse;
import org.example.dto_response.teacher.GetTeachersResponse;

public interface TeacherService {

    AddTeacherResponse addTeacher(AddTeacherRequest request) throws JsonProcessingException;

    String deleteTeacher(DeleteTeacherRequest request) throws JsonProcessingException;

    String editTeacher(EditTeacherRequest request) throws JsonProcessingException;

    GetTeacherByIdResponse getTeacherById(GetTeacherByIdRequest request) throws JsonProcessingException;

    GetTeachersResponse getTeachers() throws JsonProcessingException;

}
