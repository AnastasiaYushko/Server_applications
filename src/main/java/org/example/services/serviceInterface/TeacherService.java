package org.example.services.serviceInterface;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto.dtoRequest.teacher.AddTeacherRequest;
import org.example.dto.dtoRequest.teacher.DeleteTeacherRequest;
import org.example.dto.dtoRequest.teacher.EditTeacherRequest;
import org.example.dto.dtoRequest.teacher.GetTeacherByIdRequest;
import org.example.dto.dtoResponse.teacher.AddTeacherResponse;
import org.example.dto.dtoResponse.teacher.GetTeacherByIdResponse;
import org.example.dto.dtoResponse.teacher.GetTeachersResponse;

import javax.jcr.RepositoryException;
import javax.xml.rpc.ServiceException;

public interface TeacherService {

    AddTeacherResponse addTeacher(AddTeacherRequest request) throws JsonProcessingException, RepositoryException, ServiceException;

    String deleteTeacher(DeleteTeacherRequest request) throws JsonProcessingException, RepositoryException, ServiceException;

    String editTeacher(EditTeacherRequest request) throws JsonProcessingException, RepositoryException, ServiceException;

    GetTeacherByIdResponse getTeacherById(GetTeacherByIdRequest request) throws JsonProcessingException, RepositoryException, ServiceException;

    GetTeachersResponse getTeachers() throws JsonProcessingException, ServiceException;

}
