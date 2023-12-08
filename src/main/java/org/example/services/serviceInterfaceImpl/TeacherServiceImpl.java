package org.example.services.serviceInterfaceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto_request.teacher.add.AddTeacherRequest;
import org.example.dto_request.teacher.delete.DeleteTeacherRequest;
import org.example.dto_request.teacher.edit.EditTeacherRequest;
import org.example.dto_request.teacher.get.GetTeacherByIdRequest;
import org.example.dto_response.teacher.AddTeacherResponse;
import org.example.dto_response.teacher.EditTeacherResponse;
import org.example.dto_response.teacher.GetTeacherByIdResponse;
import org.example.dto_response.teacher.GetTeachersResponse;
import org.example.services.serviceInterface.TeacherService;

public class TeacherServiceImpl implements TeacherService {
    @Override
    public AddTeacherResponse addTeacher(AddTeacherRequest request) throws JsonProcessingException {
        return null;
    }

    @Override
    public void deleteTeacher(DeleteTeacherRequest request) throws JsonProcessingException {

    }

    @Override
    public EditTeacherResponse editTeacher(EditTeacherRequest request) throws JsonProcessingException {
        return null;
    }

    @Override
    public GetTeacherByIdResponse getTeacherById(GetTeacherByIdRequest request) throws JsonProcessingException {
        return null;
    }

    @Override
    public GetTeachersResponse getTeachers() throws JsonProcessingException {
        return null;
    }
}
