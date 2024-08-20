package org.example.services.serviceInterface;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto.dtoRequest.teacher.AddTeacherRequest;
import org.example.dto.dtoRequest.teacher.DeleteTeacherRequest;
import org.example.dto.dtoRequest.teacher.EditTeacherRequest;
import org.example.dto.dtoRequest.teacher.GetTeacherByIdRequest;
import org.example.dto.dtoResponse.teacher.AddTeacherResponse;
import org.example.dto.dtoResponse.teacher.GetTeacherByIdResponse;
import org.example.dto.dtoResponse.teacher.GetTeachersResponse;
import org.example.myExceptions.AddEntityMatchData;
import org.example.myExceptions.ChangesEntityLeadToConflict;
import org.example.myExceptions.EntityNotFoundInDataBase;
import org.example.myExceptions.StupidChanges;

import javax.jcr.RepositoryException;
import javax.xml.rpc.ServiceException;

public interface TeacherService {

    AddTeacherResponse addTeacher(AddTeacherRequest request) throws JsonProcessingException, RepositoryException, ServiceException, AddEntityMatchData;

    String deleteTeacher(DeleteTeacherRequest request) throws JsonProcessingException, RepositoryException, ServiceException, EntityNotFoundInDataBase;

    String editTeacher(EditTeacherRequest request) throws JsonProcessingException, RepositoryException, ServiceException, StupidChanges, ChangesEntityLeadToConflict, EntityNotFoundInDataBase;

    GetTeacherByIdResponse getTeacherById(GetTeacherByIdRequest request) throws JsonProcessingException, RepositoryException, ServiceException, EntityNotFoundInDataBase;

    GetTeachersResponse getTeachers() throws JsonProcessingException, ServiceException;

}
